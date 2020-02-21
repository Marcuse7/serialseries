/**
 * 
 */

function subscription(e) {
	if (e.checked) {
	$.ajax({
        url: '/series/subscribe',
        data: { seriesId: e.getAttribute("data-seriesid") }
    });
	} else {
		$.ajax({
	        url: '/series/unsubscribe',
	        data: { seriesId: e.getAttribute("data-seriesid") }
	    });
		
	}

}