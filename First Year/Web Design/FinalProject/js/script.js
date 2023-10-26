

function validateForm() {

  var fromV = document.getElementById("from");
  if (fromV.value == "") {
    alert("Please enter where you are going to fly from")
    fromV.focus();
    return false;
  } else {
    if (!checkCityFrom()) {
      alert("Please enter where you are going to fly from in correct form")
      fromV.focus();
      return false;
    }
  }

  var toV = document.getElementById("to");
  if (toV.value == "") {
    alert("Please enter where you are going to fly to")
    toV.focus();
    return false;
  } else {
    if (!checkCityTo()) {
      alert("Please enter where you are going to fly to in correct form")
      toV.focus();
      return false;
    }
  }

  var dateV = document.getElementById("date");
  if (dateV.value == "") {
    alert("Please enter date")
    dateV.focus();
    return false;
  } else {
    if (!checkDate()) {
      alert("Please enter date in correct form")
      dateV.focus();
      return false;
    }
  }

  var adult = document.getElementById("adult");
  if (adult.value == "") {
    alert("Please enter number of adults")
    adult.focus();
    return false;
  } else {
    if (!checkAdult()) {
      alert("Please enter correct number of adults")
      adult.focus();
      return false;
    }
  }

  var child = document.getElementById("child");
  if (child.value == "") {
    alert("Please enter number of children")
    child.focus();
    return false;
  } else {
    if (!checkChild()) {
      alert("Please enter correct number of children")
      tchild.focus();
      return false;
    }
  }

  var infant = document.getElementById("infant");
  if (infant.value == "") {
    alert("Please enter number of infants")
    infant.focus();
    return false;
  } else {
    if (!checkInfant()) {
      alert("Please enter correct number of infants")
      infant.focus();
      return false;
    }
  }

  getDestination()
}

function checkCityFrom() {
  var fromV = document.getElementById("from");
  var lfrom = document.getElementById("lfrom");

  var regExpName = /^[A-Z]{3}$/;

  if (!regExpName.test(fromV.value)) {
    lfrom.style.color = "red";
    lfrom.innerHTML = "Only 3 caps latters";
    return false;
  } else {
    lfrom.innerHTML = "";
    return true;
  }
}

function checkCityTo() {
  var toV = document.getElementById("to");
  var lto = document.getElementById("lto");

  var regExpName = /^[A-Z]{3}$/;

  if (!regExpName.test(toV.value)) {
    lto.style.color = "red";
    lto.innerHTML = "Only 3 caps latters";
    return false;
  } else {
    lto.innerHTML = "";
    return true;
  }
}

function checkDate() {
  var dateV = document.getElementById("date");
  var ldate = document.getElementById("ldate");

  var regExpName = /^(202[3-9])\-(0[1-9]|1[012])\-(0[1-9]|[12][0-9]|3[01])$/;

  if (!regExpName.test(dateV.value)) {
    ldate.style.color = "red";
    ldate.innerHTML = "Date in this form yyyy-mm-dd";
    return false;
  } else {
    ldate.innerHTML = "";
    return true;
  }
}

function checkAdult() {
  var adult = document.getElementById("adult");
  var ladult = document.getElementById("ladult");

  var regExpName = /^[1-9]{1}$/;

  if (!regExpName.test(adult.value)) {
    ladult.style.color = "red";
    ladult.innerHTML = "Max 9 adults min 1";
    return false;
  } else {
    ladult.innerHTML = "";
    return true;
  }
}

function checkChild() {
  var child = document.getElementById("child");
  var lchild = document.getElementById("lchild");

  var regExpName = /^[0-9]{1}$/;

  if (!regExpName.test(child.value)) {
    lchild.style.color = "red";
    lchild.innerHTML = "Max 9 children";
    return false;
  } else {
    lchild.innerHTML = "";
    return true;
  }
}

function checkInfant() {
  var infant = document.getElementById("infant");
  var linfant = document.getElementById("linfant");

  var regExpName = /^[0-2]{1}$/;

  if (!regExpName.test(infant.value)) {
    linfant.style.color = "red";
    linfant.innerHTML = "Max 9 infants";
    return false;
  } else {
    linfant.innerHTML = "";
    return true;
  }
}

function getDestination() {

  var fromV = document.getElementById("from").value;
  var toV = document.getElementById("to").value;
  var dateV = document.getElementById("date").value;
  var adult = document.getElementById("adult").value;
  var child = document.getElementById("child").value;
  var infant = document.getElementById("infant").value;
  var typeV = document.getElementById("type").value;
  var currency = document.getElementById("currency").value;

  var url = 'https://flight-fare-search.p.rapidapi.com/v2/flights/?from=' + fromV + '&to=' + toV + '&date=' + dateV + '&adult=' + adult + '&child=' + child + '&infant=' + infant + '&type=' + typeV + '&currency=' + currency

  apiCall(url);
  return url;
}

async function apiCall(urlG) {
  const options = {
    method: 'GET',
    headers: {
      'X-RapidAPI-Key': '3b618ff1b2msh049d980ac57ee92p1b1ba4jsnc7cf935be78d',
      'X-RapidAPI-Host': 'flight-fare-search.p.rapidapi.com'
    }
  };

  try {
    const response = await fetch(urlG, options);
    const result = await response.text();
    var data = JSON.parse(result);

    document.getElementById('suc').innerHTML = "Results";

    for (let i = 0; i < 5; i++) {
      try {
        document.getElementById('flight-code' + i).innerHTML = "Flight code: " + data.results[i].flight_code;
        document.getElementById('flight-name' + i).innerHTML = "Flight name: " + data.results[i].flight_name;
        document.getElementById('Dtime' + i).innerHTML = "Departure time: " + data.results[i].departureAirport.time;
        document.getElementById('Dtime-zone' + i).innerHTML = "Departure time zone: " + data.results[i].departureAirport.timeZone;
        document.getElementById('duration' + i).innerHTML = "Duration: " + data.results[i].duration.text;
        document.getElementById('price' + i).innerHTML = "Price: " + data.results[i].totals.total;
        document.getElementById('Atime' + i).innerHTML = "Arrival time: " + data.results[i].arrivalAirport.time;
        document.getElementById('Atime-zone' + i).innerHTML = "Arrival time zone: " + data.results[i].arrivalAirport.timeZone;
      } catch (error) {
        break
      }
    }

  } catch (error) {
    document.getElementById('suc').innerHTML = "Destinations not found"
  }
}