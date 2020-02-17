/**
 * 
 */

function subscription(e) {
	if (e.checked) {
	$.ajax({
        url: '/series/subscribe',
        data: { seriesID: e.getAttribute("data-seriesid") }
    });
	} else {
		$.ajax({
	        url: '/series/unsubscribe',
	        data: { seriesID: e.getAttribute("data-seriesid") }
	    });
		
	}

}