package com.expedia.hotels.business;

public class OfferError {
	private OfferErrorInfo offerErrorInfo;

    public OfferErrorInfo getOfferErrorInfo ()
    {
        return offerErrorInfo;
    }

    public void setOfferErrorInfo (OfferErrorInfo offerErrorInfo)
    {
        this.offerErrorInfo = offerErrorInfo;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [offerErrorInfo = "+offerErrorInfo+"]";
    }
}
