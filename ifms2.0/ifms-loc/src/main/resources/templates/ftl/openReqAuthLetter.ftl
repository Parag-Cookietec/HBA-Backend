<html>
<head>
<style>
.container {
    max-width: 100%;
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
    font-size: 9px;
}
.table-striped  tr:nth-of-type(odd) {
    background-color: rgba(0,0,0,.05);
}

td {
    display: table-cell;
    vertical-align: inherit;
}
.text-center {
    text-align: center!important;
}
.height-100 {
    height: 50px;
}
.font-size {
    font-size: 9px;
}
</style>
</head>
<body>

<div class="container">
  <div class="form-wrapper statement" style="padding: 10px 100px;">
    <div class="text-center">
      <h4><u>Organization Data</u></h4>
    </div>

    <table class="table-striped" style="width: 100%;">
      <tr>
        <td style="width: 30%;">Name of Office: </td>
        <td><#if header.divisionName??>${header.divisionName}</#if></td>
      </tr>
      <tr>
        <td>Address of Office: </td>
        <td><#if header.divOffAdd??>${header.divOffAdd}</#if></td>
      </tr>
      <tr>
        <td>AG's Authorization No.: </td>
        <td><#if agOffcDtl.authorizationNo??>${agOffcDtl.authorizationNo}</#if></td>
      </tr>
      <tr>
        <td>AG's Authorization Date.: </td>
        <td><#if agOffcDtl.authorizationDt??>${agOffcDtl.authorizationDt?string('dd-MMM-yyyy')}</#if></td>
      </tr>
      <tr>
        <td>Division Code (Fillable at Treasury): </td>
        <td></td>
      </tr>
    </table>

<h5> <b> Head Chargeable:</b> </h5> 
    <div class="text-center">
      <table class="table-bordered" style="width: 50%;">
        <tr>
          <td style="width: 50%;">Grant No.: </td>
          <td>000</td>
        </tr>
        <tr>
          <td>Major Head: </td>
          <td><#if agOffcDtl.majorHeadCode??>${agOffcDtl.majorHeadCode}</#if></td>
        </tr>
        <tr>
          <td>Sub Major Head: </td>
          <td><#if agOffcDtl.subMajorHeadCode??>${agOffcDtl.subMajorHeadCode}</#if></td>
        </tr>
        <tr>
          <td>Minor Head: </td>
          <td><#if agOffcDtl.minorHeadCode??>${agOffcDtl.minorHeadCode}</#if></td>
        </tr>
        <tr>
          <td>Sub Head: </td>
          <td><#if agOffcDtl.subHeadCode??>${agOffcDtl.subHeadCode}</#if></td>
        </tr>
        <tr>
          <td>Detailed Head: </td>
          <td><#if agOffcDtl.detailHeadCode??>${agOffcDtl.detailHeadCode}</#if></td>
        </tr>
      </table>
    </div>
<div class="font-size">
    Division Name: <#if header.divisionName??>${header.divisionName}</#if><br>
    Under Code: <#if header.circleCode??>${header.circleCode}</#if><br>
    Code Name: <#if header.circleName??>${header.circleName}</#if><br>
    Sign:
    <div class="height-100"></div>
    DDO Of the Office: <#if header.divisionName??>${header.divisionName}</#if><br>
</div>
  </div>
</div>
</body>
</html>