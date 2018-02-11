package com.expedia.hotels.business;

public class General {
	private Destination destination = null;
	private Hotel hotel = null;
	private HotelInfo hotelInfo = null;
	private HotelOffer hotelOffer = null;
	private HotelPricingInfo hotelPricingInfo = null;
	private OfferDateRange offerDateRange = null;
	private Offers offers = null;
	private Persona persona = null;
	private UserInfo userInfo = null;

	public General() {
		super();
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public HotelInfo getHotelInfo() {
		return hotelInfo;
	}

	public void setHotelInfo(HotelInfo hotelInfo) {
		this.hotelInfo = hotelInfo;
	}

	public HotelOffer getHotelOffer() {
		return hotelOffer;
	}

	public void setHotelOffer(HotelOffer hotelOffer) {
		this.hotelOffer = hotelOffer;
	}

	public HotelPricingInfo getHotelPricingInfo() {
		return hotelPricingInfo;
	}

	public void setHotelPricingInfo(HotelPricingInfo hotelPricingInfo) {
		this.hotelPricingInfo = hotelPricingInfo;
	}

	public OfferDateRange getOfferDateRange() {
		return offerDateRange;
	}

	public void setOfferDateRange(OfferDateRange offerDateRange) {
		this.offerDateRange = offerDateRange;
	}

	public Offers getOffers() {
		return offers;
	}

	public void setOffers(Offers offers) {
		this.offers = offers;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public General(Destination destination, Hotel hotel, HotelInfo hotelInfo, HotelOffer hotelOffer,
			HotelPricingInfo hotelPricingInfo, OfferDateRange offerDateRange, Offers offers, Persona persona,
			UserInfo userInfo) {
		super();
		this.destination = destination;
		this.hotel = hotel;
		this.hotelInfo = hotelInfo;
		this.hotelOffer = hotelOffer;
		this.hotelPricingInfo = hotelPricingInfo;
		this.offerDateRange = offerDateRange;
		this.offers = offers;
		this.persona = persona;
		this.userInfo = userInfo;
	}

}
