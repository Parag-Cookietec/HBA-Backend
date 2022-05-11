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
    font-size: 12px;
}
.h1, .h2, .h3, .h4, .h5, .h6, h1, h2, h3, h4, h5, h6 {
    margin-bottom: .5rem;
    font-weight: 500;
    line-height: 1.2;
}
.h3, h3 {
    font-size: 1.75rem;
}
.lc-report {
    font-family: 'Times New Roman', Times, serif;
    font-size: 9px;
}
.text-right{
	text-align: right;
}
.text-center {
      text-align: center;
}

</style>
</head>
<body>
<div class="container">
  <div class="form-wrapper lc-report ">
    <div class="text-center">
      <h2><u>Letter of Credit</u></h2><br>
    </div>
    <div class="text-right" >
     <#if header.lcNo??>${header.lcNo}</#if><br>
      District Treasury Office,<br>
      Gandhinagar.<br>
      Date: <#if header.lcIssueDate??>${header.lcIssueDate?string('dd-MMM-yyyy')}</#if>
    </div>
    
    <div>
      To,<br>
      The Agent/Manager,<br>
      State Bank Of India,<br>
      Main Branch, Gandhinagar<br><br><br>

      Dear Sir,<br><br>

      In accordance with the provision of Finance Department, Government Resolution No. TJR-1193-677-Z dated 19/09/94.<br><br>

      I have the honour to request that you will cash the cheques drawn by the <#if header.divCode??>${header.divCode}-${header.divName}</#if> to the extent of Rs. <#if header.balanceLcAmt??>${header.balanceLcAmt?string(",##0.00")} (${lcTotalInWord})</#if> .

      The progressive Amount of LC with this LC is now Rs. (<#if header.newBalanceLcAmt??>${header.newBalanceLcAmt?string(",##0.00")} + ${header.balanceLcAmt?string(",##0.00")}) = ${progAmt?string(",##0.00")} (${progTotalInWord})</#if> .<br><br>

      This letter of credit has effect for the quarter from <#if header.lcValidFrom??>${header.lcValidFrom?string('dd-MMM-yyyy')}</#if> to the <#if header.lcValidTo??>${header.lcValidTo?string('dd-MMM-yyyy')}</#if> Code:<#if header.divCode??>${header.divCode}-${header.divName}</#if>
    </div>
    <br>
    <div class="text-right">
      Yours faithfully,<br><br>
      District Treasury Officer,
      Gandhinagar
    </div>
    <div>
      Copy To:<br>
      1) <#if header.lcNo??>${header.lcNo}</#if>- <#if header.divCode??>${header.divCode}</#if><br>
      2) CFRST - PRINCIPAL CHIEF CONSERVATOR OF FOREST GUJ.ST.GNR.<br>
         </div>
  </div>
</div>
</body>
</html>