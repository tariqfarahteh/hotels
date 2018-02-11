const server_url = "/rest/"
const api_getOffers = server_url + "hoteloffers"




function submitForm(btnClick) {
    let form = $(btnClick).closest('form')[0];
    let data = getFormData(form);
    this.getHotelsOffers(data);
}

function getFormData(form) {
    let data = {};

    $(form).find("input:not([type=button])").each(function () {
        if (this.value && this.value.toString().length > 0) {
            data[this.name] = this.value;
        }
    });

    return data;
}

function getHotelsOffers(data) {

    $.ajax({
        headers: {
            'Content-Type': 'application/json'
        },
        type: 'GET',
        url: api_getOffers,
        dataType: 'json',
        data: data,
        success: function (data, result) {
            if (result) {
                drawHotelsOfferData(data);
            } else {
                clearData();
                console.log(data);
                console.log(result);
            }
        },
        error: function (xmlHttpRequest, textStatus, errorThrown) {
            clearData();
            console.log(xmlHttpRequest.responseText);
            console.log("Status: " + textStatus);
            console.log("Error: " + errorThrown);
        }
    });
}


function drawHotelsOfferData(data) {
    clearData();

    let ulElem = document.getElementById('ul_Hotels');
    for (let i = 0; i < data.length; i++) {
        let offer = data[i];

        let li = document.createElement("li");
        $(li).append($.parseHTML(createHotelOfferDiv(offer)));
        ulElem.appendChild(li);
    }

    if (ulElem.children.length) {
        $('.div-no-data').css('display', 'none');
    }
}

function clearData() {
    let ulElem = document.getElementById('ul_Hotels');
    $(ulElem).find('li').remove();
    $('.div-no-data').css('display', 'block');
}

function createHotelOfferDiv(offer) {
    console.log(offer);
    let result = "<div class='div-hotel-offer-item'>";

    result += "<div class='div-hotel-image'> <img src='" + offer.hotelInfo.hotelImageUrl + "' class='img-hotel'/> </div>";
    result += "<div class='div-hotel-name'>" + offer.hotelInfo.hotelName + "</div>";

    result += "<div class='div-hotel-destination'>";
    result += offer.destination.longName;
    result += offer.hotelInfo.hotelDestination;
    result += "</div>";


    result += "<div class='div-hotel-pricing'>";

    result += "<div class='div-hote-org-price'>" + offer.hotelPricingInfo.originalPricePerNight + offer.hotelPricingInfo.currency + "</div>";
    result += "<div class='div-hote-total-price'>" + offer.hotelPricingInfo.totalPriceValue + offer.hotelPricingInfo.currency + "</div>";
    result += "</div>";
    //result += offer.hotelPricingInfo.percentSavings;

    result += "<div class='div-hotel-image'> <a href='" + offer.hotelUrls.hotelInfositeUrl + "' class='a-hotel-site'>  More Inforation </a></div>";

    result += "</div>"
    return result;
}


function clearForm(btnClick) {
    let form = $(btnClick).closest('form')[0];

    $(form).find("input:not([type=button])").each(function () {
        this.value = "";
    });

}


$(document).ready(function () {
    $('#btnSearch').click();
});


