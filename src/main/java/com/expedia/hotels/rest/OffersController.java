package com.expedia.hotels.rest;

import java.util.Iterator;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.expedia.hotels.Log;
import com.expedia.hotels.Startup;
import com.expedia.hotels.business.General;
import com.expedia.hotels.business.OfferError;
import com.expedia.hotels.exception.BusinessException;
import com.expedia.hotels.props.PropertiesHandler;
import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * 
 * This controller is used for hotel offers operations.
 * 
 * @author Tariq
 */
@Path("/hoteloffers")
public class OffersController {
	private Gson gson = new Gson();
	private static String EQUAL_SIGN = "=";
	private static String AMPERSAND_SIGN = "&";
	private static String PROPERTY_NAME_SCENARIO = "scenario";
	private static String PROPERTY_NAME_UID = "uid";
	private static String PROPERTY_NAME_PRODUCT_TYPE = "productType";
	private static String PROPERTY_NAME_PAGE = "page";
	private static String PROPERTY_NAME_BASE_URL = "baseUrl";
	private StringBuilder url;
	{
		try {
			url = new StringBuilder(
					PropertiesHandler.readproperty(Startup.configProp, PROPERTY_NAME_BASE_URL));
		} catch (BusinessException e) {
			throw new RuntimeException(e);
		}

	}
	/**
	 * Get all existing hotel offers filtered based on dynamic parameters.
	 * 
	 * @param uri
	 * @return Response contains status and result
	 * @author Tariq
	 */

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getHotelOffers(@Context UriInfo uri) {

		if (!isRequiredParamValid()) {
			return Response.status(Response.Status.BAD_REQUEST).entity("Error : Missing Parameter").build();
		}

		MultivaluedMap<String, String> queryParams = uri.getQueryParameters();
		readAndFillParams(queryParams);
		Client client = Client.create();
		Log.info(this, url.toString());
		WebResource webResource = client.resource(url.toString());
		ClientResponse response = webResource.type("application/json").get(ClientResponse.class);

		String output = response.getEntity(String.class);
		if (response.getStatus() != Response.Status.OK.getStatusCode()) {
			Log.info(this, url.toString());
			handlingError(output);
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("Internal Server Error - Failed to get Offers").build();

		}

		// All objects should be filled in the line below
		General generalResponse = gson.fromJson(output, General.class);
		// for (Hotel hot : ge.getOffers().getHotel()) {
		// System.out.println(hot.getHotelInfo().getHotelId());
		// }

		if (generalResponse.getOffers() == null) {
			new BusinessException("Internal Server Error - Failed to get Offers");
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("Internal Server Error - Failed to get Offers").build();
		}

		if (generalResponse.getOffers().getHotel() == null) {
			new BusinessException("Internal Server Error - Failed to get Hotels");
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("Internal Server Error - Failed to get Hotels").build();
		}

		String hotelOffer = gson.toJson(generalResponse.getOffers().getHotel());
		return Response.status(Response.Status.OK).entity(hotelOffer).build();

	}

	/**
	 * Handling errors returned from API.
	 * 
	 * @param result
	 * @author Tariq
	 */
	private void handlingError(String result) {
		OfferError oe = gson.fromJson(result, OfferError.class);
		new BusinessException(oe.getOfferErrorInfo().getErrorCode() + " - " + oe.getOfferErrorInfo().getErrorMessage());
	}

	/**
	 * Check required parameter is exist and append them to the API URL
	 * 
	 * @return True if and only if all required parameter are exists and filled
	 *         successfully, False if any of the required parameter is missing
	 *         or empty value
	 * @author Tariq
	 */
	private boolean isRequiredParamValid() {
		try {
			String propValue = PropertiesHandler.readproperty(Startup.configProp, PROPERTY_NAME_BASE_URL);
			if (propValue.isEmpty()) {
				return false;
			}

			propValue = PropertiesHandler.readproperty(Startup.configProp, PROPERTY_NAME_SCENARIO);
			if (propValue.isEmpty()) {
				return false;
			}

			addParamtoUrl(PROPERTY_NAME_SCENARIO, propValue, false);

			propValue = PropertiesHandler.readproperty(Startup.configProp, PROPERTY_NAME_UID);

			if (propValue.isEmpty()) {
				return false;
			}

			addParamtoUrl(PROPERTY_NAME_UID, propValue, true);
			propValue = PropertiesHandler.readproperty(Startup.configProp, PROPERTY_NAME_PRODUCT_TYPE);

			if (propValue.isEmpty()) {
				return false;
			}

			addParamtoUrl(PROPERTY_NAME_PRODUCT_TYPE, propValue, true);
			propValue = PropertiesHandler.readproperty(Startup.configProp, PROPERTY_NAME_PAGE);

			if (PropertiesHandler.readproperty(Startup.configProp, PROPERTY_NAME_PAGE).isEmpty()) {
				return false;
			}

			addParamtoUrl(PROPERTY_NAME_PAGE, propValue, true);
			return true;
		} catch (BusinessException ex) {
			Log.fatal(this, ex.getMessage());
			return false;
		}
	}

	/**
	 * Read parameter that comes from the client append them to the API URL to
	 * filter results
	 * 
	 * @param queryParams
	 *            contains dynamic number of params
	 * @author Tariq
	 */
	private void readAndFillParams(MultivaluedMap<String, String> queryParams) {

		Iterator<String> it = queryParams.keySet().iterator();
		if (it.hasNext()) {
			url.append(AMPERSAND_SIGN);
		}

		while (it.hasNext()) {
			String key = it.next();

			url.append(key);
			url.append(EQUAL_SIGN);
			url.append(queryParams.get(key).get(0));
			if (it.hasNext()) {
				url.append(AMPERSAND_SIGN);
			}
		}

	}

	/**
	 * Append specific parameter to the API URL
	 * 
	 * @param key
	 *            parameter name
	 * @param value
	 *            parameter value
	 * @param withAndSign
	 *            to add "&" sign before appending parameter
	 * @author Tariq
	 */
	private void addParamtoUrl(String key, String value, boolean withAndSign) {

		if (withAndSign) {
			url.append(AMPERSAND_SIGN);
		}
		url.append(key);
		url.append(EQUAL_SIGN);
		url.append(value);

	}
}
