<html>
<head>
<style>
.container-chq{
	width:80%;
	margin:30px auto;
	border:1px solid #000;
	padding:10px;
	display: block;
	height: 210px;
	font-size:9px;
}

.text-align{
    float:right;
    font-size:9px;
}
.clear{
   clear:both;
   font-size:9px;
}
.cheq-column{
   width:95%;
   margin:3% 1%;
   font-size:9px;
	
}
.line{
	width:100%;
	border-bottom:1px solid #000;
	margin:20px auto;
	font-size:9px;

}
.ac-payee{
	width:20%;
	margin:50px auto;
	margin-top:1px dotted #000;
	border-bottom-style: dotted;
	border-top-style: dotted;
	padding:10px;
	font-size:9px;
}
.row-line{
   width:75%;
   line-height:2;
   font-size:9px;
}
.row-span-right{
   width:25%;
   font-size:9px;
}
.rupees{
    border:1px solid #000;
	padding:19px 9px 4px;
	font-size:25px;
	font-size:9px;
}
</style>
</head>
<body>
<div class="container">
    <div class="container-chq">
	<p>
		   </p>
	
	 <div class="right-column">
	        <span class="text-align"><#if header.chequeDate??>${header.chequeDate?string('dd-MM-yyyy')}</#if></span>
			<div class="clear"></div>
	  </div>
	       
	   <div class="cheq-column">
	      <div >
	       <span ><#if header.partyName??>${header.partyName}</#if><span>
		   </div>
		   <p>
		   </p>

		    <div >
		   <span class="row-line"><#if header.chequeAmount??>${lcTotalInWord}</#if><span>
		   </div>
		   <p>
		   </p>
		   <p>
		   </p>
		   <div>
		      
		      <div style="float:right" ></div>
				 <div  class="row-span-right"  style="float:right">
				   <b ><#if header.chequeAmount??>${header.chequeAmount?string(",##0.00")}</#if></b>
				 </div>
				 <div class="clear"></div>
			 
		   </div>
		   
		   <div class="ac-payee"style="float:right">
		      <span>A/C PAYEE ONLY</span>
		   </div>
	   </div>
	
	</div>
	
</div>
</body>
</html>