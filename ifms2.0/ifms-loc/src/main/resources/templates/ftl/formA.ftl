<html>
<head>
<style>
.container {
    width: 90%;
    padding-right: 15px;
    padding-left: 15px;
    margin-right: auto;
    margin-left: auto;
}
.form-wrapper {
    width: 100%;
    margin: 1em auto;
    background: #fff;
    border-radius: 0px;
    box-shadow: 0px 0px 10px #e2e2e2;
    height: auto;
    padding: 1em;
}

.lc-report{
    font-family: 'Times New Roman', Times, serif  !important;
    font-size: 9px !important;
}
.lc-report table {
    width: 50%;
    font-size: 9px;
}
.lc-report table, .lc-report table tr th, .lc-report table tr td {
    border: 1px solid #000000;
}

table {
    border-collapse: collapse;
}
.lc-report table tr th, .lc-report table tr:nth-child(2) {
    text-align: center;
}

.lc-report table tr th, .lc-report table tr td {
    padding: 10px;
}
.text-right{
text-align: right
}
.text-center{
text-align: center
}

</style>
</head>

<body>
<div class="container">
  <div class="form-wrapper lc-report">
    <div class="text-right">
      <h4> <#if header.divCode??>${header.divCode}</#if></h4>
    </div>
		<img width="160px" height="50" style="vertical-align: middle;" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAJYAAABJCAYAAADfad8YAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyJpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuMy1jMDExIDY2LjE0NTY2MSwgMjAxMi8wMi8wNi0xNDo1NjoyNyAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENTNiAoV2luZG93cykiIHhtcE1NOkluc3RhbmNlSUQ9InhtcC5paWQ6MEU0NjFGNTI0QjNGMTFFOTk0OTVEMTlDQzE5NzdDOTkiIHhtcE1NOkRvY3VtZW50SUQ9InhtcC5kaWQ6MEU0NjFGNTM0QjNGMTFFOTk0OTVEMTlDQzE5NzdDOTkiPiA8eG1wTU06RGVyaXZlZEZyb20gc3RSZWY6aW5zdGFuY2VJRD0ieG1wLmlpZDowRTQ2MUY1MDRCM0YxMUU5OTQ5NUQxOUNDMTk3N0M5OSIgc3RSZWY6ZG9jdW1lbnRJRD0ieG1wLmRpZDowRTQ2MUY1MTRCM0YxMUU5OTQ5NUQxOUNDMTk3N0M5OSIvPiA8L3JkZjpEZXNjcmlwdGlvbj4gPC9yZGY6UkRGPiA8L3g6eG1wbWV0YT4gPD94cGFja2V0IGVuZD0iciI/PjVq6dkAABAjSURBVHja7J17kBxV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"></td>
			<div class="text-center">
      <h4><u>Form A </u></h4>
      <h5>G.T.R. 16<br>
        (See Rule 102(1))</h5>
    </div>
			<td style="width:20%;"><img width="140" height="90" src="data:image/png;base64,${qrCode}" /></td>


    
    <div class="text-right">
     <#if header.divName??>${header.divName}</#if><br>
      Date : ${currDate?string('dd-MMM-yyyy')}<br>
      @For Plan Grant<br>
      @For Non-Plan Grant<br>
      @For Outsite Boundary Work
    </div>
    <div>
      To,<br>
      The Treasury Officer,<br>
      Gandhinagar<br><br>

      I have the honour to request that you will cash the cheque drawn by the Deputy Conservator, DEPUTY CONSERVATOR OF
      FOREST OFFICE,
      GANDHINAGAR, Gandhinagar to the extant of Rupees <#if header.balanceLcAmt??>${header.balanceLcAmt?string(",##0.00")}/- (${lcTotalInWord})</#if>| date : <#if header.lcIssueDate??>${header.lcIssueDate?string('dd-MMM-yyyy')}</#if>
     <br><br>

      This letter of credit has effected from <#if header.lcValidFrom??>${header.lcValidFrom?string('dd-MMM-yyyy')}</#if> to <#if header.lcValidTo??>${header.lcValidTo?string('dd-MMM-yyyy')}</#if><br><br>

      1. Sub Treasury Rs. - __________<br>
      2. Sub Treasury Rs. - __________<br>
      3. Sub Treasury Rs. - __________<br><br>

      Total of Sub Treasury - __________<br>
      Balance for the District Treasury <u>Rs.<#if header.newBalanceLcAmt??>${header.newBalanceLcAmt?string(",##0.00")}/-</#if></u><br><br>

      This letter of credit is being issues under the Budget Head shown below along with the amount of L.O.C. already
      issued and the
      additional amount of L.O.C. now.<br><br>
      <p style="page-break-after: always;">&nbsp;</p>
    </div>
    <div class="text-right">
      (Rs. in Lacs)
    </div>
    <div>
      <table>
        <tr>
          <th>Sr. No.</th>
          <th>Head of Account (Here mention details of Major/Minor & Sub Head</th>
          <th>Sanctioned Budget Grant for the year Rs.</th>
          <th>Amount of L.O.C. already issued for Rs.</th>
          <th>Amount of L.O.C. now issued for Rs.</th>
          <th>Center Balance Available after this Rs.</th>
          <th>State Balance Available after this Rs.</th>
          <th>Remarks</th>
        </tr>
        <tr>
          <td>1</td>
          <td>2</td>
          <td>3</td>
          <td>4</td>
          <td>5</td>
          <td>6</td>
          <td>7</td>
          <td>8</td>
        </tr>
       <#assign count = 0>
       <#foreach detail in detail>
        <tr>
          <td><#assign count = count + 1> ${count}</td>
          <td><#if detail.majorHeadName??>${detail.majorHeadName},${detail.minorHeadName},${detail.subHeadName}</#if></td>
          <td>0.0</td>
          <td>0.0</td>
          <td class="text-right"><#if detail.centerAmount??>${detail.centerAmount?string(",##0.00")}</#if></td>
           <td class="text-right"><#if detail.stateAmount??>${detail.stateAmount?string(",##0.00")}</#if></td>
          <td>--</td>
          <td>--</td>
        </tr>
         </#foreach>
        <tr>
          <td></td>
          <td><strong>Total Rs.</strong></td>
          <td><strong>0.00</strong></td>
          <td><strong>0.00</strong></td>
          <td class="text-right"><strong>${centerLcIssuedTotal?string(",##0.00")}</strong></td>
          <td class="text-right"><strong>${stateLcIssuedTotal?string(",##0.00")}</strong></td>
          <td>--</td>
          <td>--</td>
        </tr>
      </table>
    </div>
    <div class="height-100"></div>
    <div class="float-right">
      <div class="text-right">
        PRINCIPAL CHIEF CONSERVATOR OF FOREST GUJ.ST.GNR<br>
        Code No. 986
      </div>
    </div>
    <div class="height-40"></div>
  </div>
</div>
</body>
</html>