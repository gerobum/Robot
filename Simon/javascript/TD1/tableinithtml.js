"use strict";

var htmlTable = TableMultiplication.tableMultiplicationHTML;

function ecrireTableMultiplication(n, nblignes) {
    nblignes = nblignes || 12;
    document.getElementById("tablemult").innerHTML = htmlTable(n, nblignes);
}

(function () {
    function init(event) {
        ecrireTableMultiplication(5, 12);
    }
    window.addEventListener("load", init, false);
})();

var TableMultiplication = TableMultiplication || {};


(function (exports) {

    function tableMultiplicationHTML(n, nblignes)
    {
        return '<p>Table de multiplication de <span class="num">'+n+'</span></p>';
    }
//export public data
    exports.tableMultiplicationHTML = tableMultiplicationHTML;
})(TableMultiplication);

