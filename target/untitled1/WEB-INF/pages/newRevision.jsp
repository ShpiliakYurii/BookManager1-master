<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script>
  function getCharact(idFeatures){
    var txt = "";
    <c:forEach items = '${characteristics}' var='characteristic'>
    if(idFeatures == ${characteristic.idFeatures}){
      txt += "<option>${characteristic.name}</option>";
    }
    </c:forEach>
    return txt;
  }

  function innerHtml(m, region){
    var isFeature = false;
    var txt = "<span id = 'regionName' value='" + region + "'>" + region + "</span><ul>";
    <c:forEach items = '${terms}' var='term'>
    if(m == ${term.idRegion}){
      txt += "<li t = '${term.name}'>${term.name}";
          <c:forEach items = '${features}' var='feature'>
          if(${term.idTerm} == ${feature.idTerm}){
            if(isFeature == false) {
              txt += "<ul>";
              isFeature = true;
            }
            txt += "<li><input type='checkbox' name='feature' value='${feature.name}'>${feature.name}";
            var fl = ${feature.last};
            if(fl == 0){
              txt += "<select name = 'char'>";
              txt += getCharact(${feature.idFeatures});
              txt += "</select>";
            }
            if(fl == 1) {
              txt += "<input type ='text' size='20'>";
            }
            txt += "</li>";
          }
          </c:forEach>
      if(isFeature == true) {
        txt += "</ul>";
        isFeature = false;
      }
      var tl = ${term.last};
      if(tl == 1)
        txt += "<input id='termInput' type ='text' size='20'>";
      txt += "</li>";
    }
    </c:forEach>
    document.getElementById('description').innerHTML = txt + "</ul><span class='button' onclick='addDescriptionElement("+m+")'>Добавити</span>";

  }
</script>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Нове обстеження</title>
  <link href="<c:url value="/resources/c/css.css"/>" rel="stylesheet">
    <script src="<c:url value="/resources/s/description.js"/>"></script>
</head>
<body>
<div id="content">
  <div id="organs">
    <c:if test = "${!empty organs}">
    <c:forEach items = "${organs}" var = "organ">
      <span class="organName">${organ.name}</span>
      <ul class="regions">
        <c:forEach items = "${regions}" var="region">
          <c:if test="${organ.idOrgan.equals(region.idOrgan)}">
            <li id="region${region.idRegion}" onclick="innerHtml('${region.idRegion}','${region.name}')"><input type="checkbox" name="region" value="${region.name}" >${region.name}</li>
          </c:if>
        </c:forEach>
      </ul>
    </c:forEach>
  </c:if>
    <span class='button' onclick="doFinallyDescription()">Завершити</span>
  </div>
  <div id="description">
  </div>
</div>
<c:if test = "${!empty revisionTypeList}">
    <c:forEach items = "${revisionTypeList}" var = "r">
      <a href="/revisionDescription/${r.id}">${r.revisionName}</a><br>
    </c:forEach>
</c:if>
</body>
</html>

