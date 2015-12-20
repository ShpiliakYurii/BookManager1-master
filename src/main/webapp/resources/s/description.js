/**
 * Created by Yurii on 17.12.2015.
 */
function addDescriptionElement(m){
    var first=true;
    var region = document.getElementById('description').children[0].getAttribute("value");
    //console.log(region);
    var description = document.getElementById('description').children[1];
    var descriptionCount = description.childNodes.length;
    for(var i = 0; i < descriptionCount; i ++){
        var term = description.childNodes[i];
        if(term.hasAttribute('t')) {
            var featuresList = term.childNodes[1];
            if(featuresList.id == 'termInput'){
                if (featuresList.value.length != 0) {
                    //console.log(term.getAttribute('t') + " " + featuresList.value);
                    if(first) {
                        if(!document.getElementById('rd'+m)) {
                            document.getElementById('region' + m).innerHTML += "<br><textarea rows='3' class='regionText' id='rd" + m + "'></textarea>";
                            document.getElementById('rd' + m).value = region + ": ";
                        }
                        first = false;
                        document.getElementById('region' + m).childNodes[0].checked = true;
                        //console.log(document.getElementById('region' + m).childNodes[0]);
                    }
                    document.getElementById('rd'+m).value += term.getAttribute('t') + " " + featuresList.value + "; ";
                    document.getElementById('description').innerHTML = "";
                }
            }else {
                for (var j = 0; j < featuresList.childNodes.length; j++) {
                    if (featuresList.childNodes[j].childNodes[0].checked) {
                        var feature = featuresList.childNodes[j].childNodes[0].value;
                        var characteristic = featuresList.childNodes[j].childNodes[2].value;
                        if (characteristic.length == 0) {
                            featuresList.childNodes[j].childNodes[2].placeholder = "Введіть дані.";
                            return;
                        }
                        //console.log(term.getAttribute('t') + " " + feature + " " + characteristic);
                        if(first) {
                            if(!document.getElementById('rd'+m)) {
                                document.getElementById('region' + m).innerHTML += "<br><textarea rows='3' class='regionText' id='rd" + m + "'></textarea>";
                                document.getElementById('rd' + m).value = region + ": ";
                            }
                            first = false;
                            document.getElementById('region' + m).childNodes[0].checked = true;
                            //console.log(document.getElementById('region' + m).childNodes[0]);
                        }
                        document.getElementById('rd'+m).value += term.getAttribute('t') + " " + feature + " " + characteristic + "; ";
                        document.getElementById('description').innerHTML = "";
                    }
                }
            }
        }
    }
}

function doFinallyDescription(){
    var finallyDescription = "";
    var first = true;
    var organs = document.getElementById('organs');
    var organ = "";
    for(var i = 0; i < organs.childNodes.length; i++){
        if(organs.childNodes[i].className == "organName"){
            //organ = organs.childNodes[i].childNodes[0];
            organ = organs.childNodes[i].childNodes[0].textContent;
            //console.log(organ);
        }
        if(organs.childNodes[i].className == "regions"){
            //console.log(organs.childNodes[i]);
            var regions = organs.childNodes[i];

            for(var j = 1; j < regions.childNodes.length; j++){
                //if(regions.childNodes[j].childNodes[0].checked){
                    //console.log(j+" "+regions.childNodes[j]);
                //}
                if(regions.childNodes[j].childNodes[0].checked){
                    if(regions.childNodes[j].childNodes[3] != undefined) {
                        //console.log(regions.childNodes[j].childNodes[3].value);
                        if(first){
                            finallyDescription += organ+" ";
                            first = false;
                        }
                        finallyDescription += regions.childNodes[j].childNodes[3].value;
                    }
                }
                j++;
            }
        }
        first = true;
    }
    //document.body.innerHTML = "<form method='post' commandName='record' action='completeRevision'><textarea path='description'></textarea></form>";
    window.location = "/completeRevision/" + finallyDescription;
    //return finallyDescription;
}