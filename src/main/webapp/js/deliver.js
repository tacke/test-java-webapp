var ad = {};

(function() {
    ad.init = function(adspotId) {
        var elements = document.getElementsByClassName('adspot');
        for (var i = 0; i < elements.length; i++) {
            var element = elements[i];
            if (element.dataset.adspotid === adspotId) {
                appendAdTag(element, adspotId);
            }
        }
    };

    var serverUrl = 'http://localhost:8080/java-test/deliver';

    var appendAdTag = function(element, adspotId) {
        var adTag = document.createElement('iframe');
        adTag.src = serverUrl + '?id=' + adspotId;
        element.appendChild(adTag);
    };
})();