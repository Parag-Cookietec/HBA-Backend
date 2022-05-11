<body>
<html>
<head>
<style>
.container {
    max-width: 97%;
}
.container {
    width: 100%;
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

.statement table {
    margin: 30px 0px;
}
table {
    border-collapse: collapse;
    font-family: 'Times New Roman', Times, serif;
    font-size: 8px;
    width:100%;
}
.variation-report, .lc-report, .print-report, .statement, .gi-statement .annexure-two {
    font-family: 'Times New Roman', Times, serif;
    font-size: 8px;
}
.table-striped  tr:nth-of-type(odd) {
    background-color: rgba(0,0,0,.05);
}

td {
    display: table-cell;
    vertical-align: inherit;
    font-size:8px;
}
.table-bordered {
    border: 1px solid #dee2e6;
}
.table-bordered tr {
    border: 1px solid #000;
}
.table-bordered td, .table-bordered th {
    border: 1px solid #dee2e6;
}
.grey-background {
    background-color: #f2f2f2;
}
.text-center {
    text-align: center;
	font-size:9px;
}

.Detl {
    text-align: center;
	font-size:81%;
	width:90%;
}
.height-50 {
    height: 50px;
}

.height-30 {
    height: 30px;
}
.deduction-table tr td:nth-child(1), .statement .deduction-table tr th {
    text-align: center;
}
.statement .table-bordered tr td:nth-child(1), .statement .table-bordered tr td:nth-child(5) {
    text-align: center;
}
.mat-drawer-container {
    background-color: #fafafa;
    color: rgba(0,0,0,.87);
    
    @page { 
    @top-center {content: element(header)}      /* Header */
    @bottom-center {content: element(footer)}   /* Enpied */
}
#header {position: running(header);}
#footer {position: running(footer);}
#pagenumber:before {content: counter(page);}
#pagecount:before {content: counter(pages);}
}

</style>
</head>

<div class="container">
  <div class="form-wrapper statement">
  <div id="footer">Page <span id="pagenumber" /> 1/3</div>
    <!-- Header Section-->
  	<div class="text-center">
			&nbsp
			</div>
		<img width="160px" height="50" style="vertical-align: middle;" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAJYAAABJCAYAAADfad8YAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyJpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuMy1jMDExIDY2LjE0NTY2MSwgMjAxMi8wMi8wNi0xNDo1NjoyNyAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENTNiAoV2luZG93cykiIHhtcE1NOkluc3RhbmNlSUQ9InhtcC5paWQ6MEU0NjFGNTI0QjNGMTFFOTk0OTVEMTlDQzE5NzdDOTkiIHhtcE1NOkRvY3VtZW50SUQ9InhtcC5kaWQ6MEU0NjFGNTM0QjNGMTFFOTk0OTVEMTlDQzE5NzdDOTkiPiA8eG1wTU06RGVyaXZlZEZyb20gc3RSZWY6aW5zdGFuY2VJRD0ieG1wLmlpZDowRTQ2MUY1MDRCM0YxMUU5OTQ5NUQxOUNDMTk3N0M5OSIgc3RSZWY6ZG9jdW1lbnRJRD0ieG1wLmRpZDowRTQ2MUY1MTRCM0YxMUU5OTQ5NUQxOUNDMTk3N0M5OSIvPiA8L3JkZjpEZXNjcmlwdGlvbj4gPC9yZGY6UkRGPiA8L3g6eG1wbWV0YT4gPD94cGFja2V0IGVuZD0iciI/PjVq6dkAABAjSURBVHja7J17kBxV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"></td>
			
			<img width="140" align="right" height="90" src="data:image/png;base64,${qrCode}" />
			
			<div class="text-center">
			&nbsp
			</div>
			<div class="text-center">
			&nbsp
			</div>
			<div class="text-center">
			&nbsp
			</div>
			
			<div class="text-center">
			<h4><u>STATEMENT-I (LC Advice Details)</u></h4>
			</div>
    <!-- Statement 1 Table Starts -->
   <table class="table-striped" >
      <tr>
        <td>Advice No.: </td>
        <td><#if header.adviceNo??>${header.adviceNo}</#if></td>
        <td>Advice Date:</td>
        <td><#if header.adviceDate??>${header.adviceDate?string('dd-MMM-yyyy')}</#if></td>
      </tr>

      <tr>
        <td>Department:</td>
        <td><#if header.deptName??>${header.deptName}</#if></td>
        <td>District:</td>
        <td><#if header.districtName??>${header.districtName}</#if></td>
      </tr>

      <tr>
        <td>Division name:</td>
        <td><#if header.divName??>${header.divName}</#if></td>
        <td>Division Code:</td>
        <td><#if header.divCode??>${header.divCode}</#if></td>
      </tr>

      <tr>
        <td>L.C.Valid From:</td>
        <td><#if header.lcValidFromDate??>${header.lcValidFromDate}</#if></td>
        <td>Month:</td>
        <td><#if header.adviceMonth??>${header.adviceMonth}</#if></td>
      </tr>

      <tr>
        <td>Opening LC Balance:</td>
        <td colspan="3"><#if header.openBlnc??>${header.openBlnc?string(",##0.00")}</#if></td>
      </tr>

      <tr>
        <td>New LC:</td>
        <td colspan="3"><#if header.newLcBlnc??>${header.newLcBlnc?string(",##0.00")}</#if></td>
      </tr>
    </table>
    <!-- Statement 1 Table Ends -->

    <!-- Cheque Details Table Starts -->
   <#if payTypeChq = true ?? >
    <table class="table-bordered" style="width: 100%;">
      <tr class="text-center grey-background">
       <th>Sr.No. </th>
        <th>Cheque Date</th>
        <th>Cheque No.</th>
        <th>Party Name</th>
        <th>Cheque Amount</th>
      </tr>
     <#assign count = 0>
	<#foreach chqDtl in chqDtl>
      <tr>
         <td><#assign count = count + 1> ${count}</td>
        <td><#if chqDtl.chequeDate??>${chqDtl.chequeDate?string('dd-MMM-yyyy')}</#if></td>
        <td><#if chqDtl.chequeNo??>${chqDtl.chequeNo}</#if></td>
        <td><#if chqDtl.vendorName??>${chqDtl.vendorName}</#if></td>
         <td class="rightAlign"><#if chqDtl.chequeAmount??>${chqDtl.chequeAmount?string(",##0.00")}</#if></td>
      </tr>
      </#foreach>
      </#if>
      <#if payTypeEpay = true ?? >
      <table class="table-bordered" style="width: 100%;">
      <tr class="text-center grey-background">
        <th>Sr.No. </th>
         <th>Party Name</th>
        <th>Bank Account Number</th>
        <th>IFSC Code.</th>
        <th>E-Payment Amount ( In Rs.)</th>
      </tr>
     <#assign count = 0>
	<#foreach chqDtl in chqDtl>
      <tr>
        <td><#assign count = count + 1> ${count}</td>
        <td><#if chqDtl.vendorName??>${chqDtl.vendorName}</#if></td>
        <td><#if chqDtl.accNo??>${chqDtl.accNo}</#if></td>
        <td><#if chqDtl.ifscCode??>${chqDtl.ifscCode}</#if></td>
         <td class="rightAlign"><#if chqDtl.epayAmnt??>${chqDtl.epayAmnt?string(",##0.00")}</#if></td>
      </tr>
      </#foreach>
       </#if>
      <tr class="text-center grey-background">
        <td><strong>Total</strong></td>
        <td></td>
        <td></td>
         <td></td>
        <td class="rightAlign"><strong><span><#if chqtotalAmount??>${chqtotalAmount?string(",##0.00")}</#if></span></strong></td>
      </tr>
    </table>
    
    
    <!-- Cheque Details Table Ends -->

    <hr>

    Closing LC Balance : <#if header.closingBlnc??>${header.closingBlnc?string(",##0.00")}</#if>

    <!-- Signature Table Starts -->
    <table>
      <tr>
        <td>
          Division Office: <#if header.officeName??>${header.officeName}</#if><br>
          District: <#if header.districtName??>${header.districtName}</#if></td>
        <td>
          Drawing Officer: <#if header.drawingOfficeName??>${header.drawingOfficeName}</#if><br>
          Treasury Office:<#if header.toOrSubToName??> ${header.toOrSubToName}</#if><br>
          Bank: <#if header.bankName??>${header.bankName}</#if></td>
      </tr>
    </table>
    <div class="height-30"></div>
   <table>
      <tr class="text-center">
        <th>Divisional Account Officer</th>
        <th><#if header.drawingOfficeName??>${header.drawingOfficeName}</#if></th>
      </tr>
    </table>

<p style="page-break-after: always;">&nbsp;</p>
 <div id="footer">Page <span id="pagenumber" /> 2/3</div>
    <!-- Signature Table Ends -->
    <div class="height-50"></div>
    <div class="text-center">
      <h4><u>STATEMENT-II (Detailed Posting)</u></h4>
    </div>

    <!-- Statement 2 Table Starts -->
    <table class="table-bordered  Detl ;>
      <tr class="grey-background">
        <th>Sr. No.</th>
        <th>LC No.</th>
        <th>Drawing Officer</th>
        <th>Fund</th>
        <th>Class Of Exp.</th>
        <th>Budget Type</th>
        <th>Demand</th>
        <th>Major Head</th>
        <th>Sub Major Head</th>
        <th>Minor Head</th>
        <th>Sub Head</th>
        <th>Detailed Head</th>
        <th>Type of Estimate</th>
        <th>Item Name / Work Name</th>
        <th>Object Class</th>
        <th>Expenditure Amount (In Rs.)</th>
      </tr>
      <#assign count = 0>
	<#foreach pstDtl in pstDtl>
      <tr>
         <td><#assign count = count + 1> ${count}</td>
        <td><#if pstDtl.lcNumber??>${pstDtl.lcNumber}</#if></td>
        <td><#if pstDtl.ddoNo??>${pstDtl.ddoNo}</#if></td>
        <td><#if pstDtl.fundType??>${pstDtl.fundType}</#if></td>
        <td><#if pstDtl.classExpend??>${pstDtl.classExpend}</#if></td>
        <td><#if pstDtl.budgetTypeName??>${pstDtl.budgetTypeName}</#if></td>
        <td><#if pstDtl.demandCode??>${pstDtl.demandCode}</#if></td>
        <td><#if pstDtl.majorHeadName??>${pstDtl.majorHeadName}</#if></td>
        <td><#if pstDtl.subMajorHeadName??>${pstDtl.subMajorHeadName}</#if></td>
        <td><#if pstDtl.minorHeadName??>${pstDtl.minorHeadName}</#if></td>
        <td><#if pstDtl.subHeadName??>${pstDtl.subHeadName}</#if></td>
        <td><#if pstDtl.detailHeadName??>${pstDtl.detailHeadName}</#if></td>
        <td><#if pstDtl.typeOfEstimate??>${pstDtl.typeOfEstimate}</#if></td>
        <td><#if pstDtl.itemWorkName??>${pstDtl.itemWorkName}</#if></td>
        <td><#if pstDtl.objectClass??>${pstDtl.objectClass}</#if></td>
        <td class="text-right"><#if pstDtl.expenditureAmount??>${pstDtl.expenditureAmount?string(",##0.00")}</#if></td>
      </tr>
 	</#foreach>
      
      <tr class="grey-background">
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td> <strong> Total (In Rs.)</strong> </td>
        <td></td>
        <td class="text-right"> <strong> <#if header.netAmt??>${header.netAmt?string(",##0.00")}</#if></strong></td>
      </tr>
      <tr class="grey-background">
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td> <strong> Deductions (In Rs.)</strong> </td>
        <td></td>
        <td class="text-right"> <strong> <#if header.dedAmt??>${header.dedAmt?string(",##0.00")}</#if></strong></td>
      </tr>
      <tr class="grey-background">
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td> <strong> Net Total (In Rs.)</strong></td>
        <td></td>
        <td class="text-right"> <strong><#if header.grossAmt??>${header.grossAmt?string(",##0.00")}</#if></strong></td>
      </tr>
    </table>
    <!-- Statement 2 Table Ends -->

    <hr>

        <strong class="text-center">Advice No. : <#if header.adviceNo??>${header.adviceNo}</#if></strong>


    <div class="height-30"></div>
    <!-- Signature Table Starts -->
   <table>
      <tr class="text-center">
        <th>Divisional Account Officer</th>
        <th> <#if header.officeName??>${header.officeName}</#if></th>
       
      </tr>
    </table>
    <!-- Signature Table Ends -->
<p style="page-break-after: always;">&nbsp;</p>
 <div id="footer">Page <span id="pagenumber" /> 3/3</div>

    <div class="text-center">
      <h4><u>Deduction Entry</u></h4>
    </div>

    <!-- Deduction Entry Table Starts -->
    <table class="table-bordered deduction-table">
      <tr class="text-center grey-background">
        <th>Sr. No.</th>
        <th>Description</th>
        <th>Amount (In Rs.)</th>
      </tr>
      <tr>
        <td>1</td>
        <td>Professional Tax(9570)</td>
        <td><#if dedDtl.ptAmt??>${dedDtl.ptAmt?string(",##0.00")}</#if></td>
      </tr>
      <tr>
        <td>2</td>
        <td>Labour Class(9528)</td>
        <td><#if dedDtl.labourAmt??>${dedDtl.labourAmt?string(",##0.00")}</#if></td>
      </tr>
      <tr>
        <td>3</td>
        <td>For All Major Heads(9998)</td>
        <td><#if dedDtl.forAllMhAmt??>${dedDtl.forAllMhAmt?string(",##0.00")}</#if></td>
      </tr>
      <tr>
        <td>4</td>
        <td>Income Tax(9510)</td>
        <td><#if dedDtl.itAmt??>${dedDtl.itAmt?string(",##0.00")}</#if></td>
      </tr>
      <tr>
        <td>5</td>
        <td>Surcharge On Income Tax(9520)</td>
        <td><#if dedDtl.surchargeAmt??>${dedDtl.surchargeAmt?string(",##0.00")}</#if></td>
      </tr>
      <tr>
        <td>6</td>
        <td>G.P.F. Class IV(9531)</td>
        <td><#if dedDtl.gpfClass4Amt??>${dedDtl.gpfClass4Amt?string(",##0.00")}</#if></td>
      </tr>
      <tr>
        <td>7</td>
        <td>CPF (9690)</td>
        <td><#if dedDtl.cpfAmt??>${dedDtl.cpfAmt?string(",##0.00")}</#if></td>
      </tr>
      <tr>
        <td>8</td>
        <td>Rent Of Building(0216)(9550)</td>
        <td><#if dedDtl.buildingRentAmt??>${dedDtl.buildingRentAmt?string(",##0.00")}</#if></td>
      </tr>
      <tr>
        <td>9</td>
        <td>Govt. Insurance Scheme-1981-Insurance Fund(9581)</td>
        <td><#if dedDtl.govtInsuFundAmt??>${dedDtl.govtInsuFundAmt?string(",##0.00")}</#if></td>
      </tr>
      <tr>
        <td>10</td>
        <td>Govt. Insurance Scheme-1981-Saving Fund(9582)</td>
        <td><#if dedDtl.insuranceFundAmt??>${dedDtl.insuranceFundAmt?string(",##0.00")}</#if></td>
      </tr>
      <tr>
        <td>11</td>
        <td>Security Deposit(9600)</td>
        <td><#if dedDtl.securityDepositAmt??>${dedDtl.securityDepositAmt?string(",##0.00")}</#if></td>
      </tr>
      <tr>
        <td>12</td>
        <td>Establishment Charges(1100)</td>
        <td><#if dedDtl.estdChargeAmt??>${dedDtl.estdChargeAmt?string(",##0.00")}</#if></td>
      </tr>
      <tr>
        <td>13</td>
        <td>Machinary Charges(1200)</td>
        <td><#if dedDtl.machineryChargeAmt??>${dedDtl.machineryChargeAmt?string(",##0.00")}</#if></td>
      </tr>
      <tr>
        <td>14</td>
        <td>Other Charges(1300)</td>
        <td>0.00</td>
      </tr>
         <tr class="text-center grey-background">
        <th>Total</th>
        <th></th>
        <th class="text-right"><#if header.dedAmt??>${header.dedAmt?string(",##0.00")}</#if></th>
      </tr>
    </table>
    <!-- Deduction Entry Table Ends -->
    <hr>

    <strong>Advice No. : <#if header.adviceNo??>${header.adviceNo}</#if></strong>

    <div class="height-50"></div>
    <!-- Signature Table Starts -->
       <table>
      <tr class="text-center">
        <th>Divisional Account Officer</th>
        <th><#if header.officeName??>${header.officeName}</#if></th>
      </tr>
    </table>
    <!-- Signature Table Ends -->

  </div>
</div>
</html>