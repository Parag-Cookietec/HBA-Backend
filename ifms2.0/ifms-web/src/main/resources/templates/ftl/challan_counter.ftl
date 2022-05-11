<html>
<head>
<title>GTR 2000</title>
<style type="text/css">
.rightAlign {
	float: right;
}

.textCenter {
	text-align: center;
}

.form-wrapper {
	box-shadow: 5px 2px 12px 10px #eae7e7;
	margin: 40px 120px;
	padding: 10px 50px;
}

.form-wrapper h3 {
	font-size: 14px;
}

.form-wrapper p {
	font-size: 10px;
}

.form-wrapper table {
	width: 100%;
}

.table-bordered, .table-bordered tr td {
	border-collapse: collapse;
	border: 1px solid #a2a2a2;
}

.table-bordered tr td {
	padding: 5px;
}

.height-100 {
	height: 50px;
	margin-right: 100px
}

@media print {
	.form-wrapper {
		box-shadow: none;
		margin: 10px;
		padding: 10px 10px;
		
	}
	table tr td {
		font-size: 10px;
	}
}
</style>
</head>
<body>

	<!-- Office Copy -->
	<div class="form-wrapper" style="page-break-after: always">
		<div class="rightAlign"><p>Office Copy</p></div>
		<br>
		<div class="textCenter">
			<h3>
				<span style="text-decoration: underline">GTR 2000</span>
			</h3>
			<p>
				<span style="text-decoration: underline">Form No.05 - <em>Form of Receipt</em> <br> <br>
					(See rule 35)
				</span>
			</p>
		</div>
		<table>
			<tr>
				<td colspan="3"><strong>Office Name : </strong> ${officeName}
					</td>
			</tr>
			<tr>
				<td style="width: 50%"><strong>DDO No. :</strong> ${ddo}</td>
				<td colspan="2"><strong>Receipt No. :</strong> ${header.challanNumber} </td>
			</tr>
			<tr>
				<td style="width: 50%"><strong>Cardex No. :</strong> ${cardex}</td>
				<td><span style="margin-right: 30%;"><strong>Date
							: </strong> ${.now?string('dd-MMM-yyyy')} <strong>&nbsp;&nbsp;&nbsp;&nbsp; Time
							: </strong> ${.now?string('HH:mm:ss')}</span></td>
			</tr>
		</table>

		<br>
		<table class="table-bordered">
			<tr>
				<td>Sr No</td>
				<td colspan="2">Particulars</td>
			</tr>
			<tr>
				<td>1</td>
				<td>Payer Name  </td>
				<td style="width: 65%;">${header.payerName}</td>
			</tr>
			<tr>
				<td>2</td>
				<td>Amount <div class="rightAlign">
						in Rs. <br/> in Words 
					</div>
					 <br/>
				
					
				</td>
				<td>${totalFormattedAmount} <br/> ${totalInWord}</td>
			</tr>
			<tr>
				<td>3</td>
				<td>Mode of payment <br/>(Cash / Cheque / DD / Postal order) </td>
				<td>
				<#if header.paymentModeId == 1393>
					Cash
				<#elseif header.paymentModeId == 1394>
					<div>
						<strong>Cheque :</strong><br>					
						Bank Name: <#if bankName??> ${bankName} </#if> <br> Cheque No.: ${header.instrumentNo} <br>
						Cheque Date : <#if header.paymentDate??> ${header.paymentDate?string('dd-MMM-yyyy')} </#if> <br>
					</div>
				<#elseif  header.paymentModeId == 1396>
					<div>
						<strong>DD :</strong><br>					
						Bank Name: <#if bankName??> ${bankName} </#if> <br> DD No.: ${header.instrumentNo} <br>
						DD Date : <#if header.paymentDate??> ${header.paymentDate?string('dd-MMM-yyyy')} </#if><br>
					</div>
				<#elseif  header.paymentModeId == 1395>
					<div >
					<strong> Postal Order :</strong><br>				
						Postal Order No.: ${header.instrumentNo} <br> Postal Order Date.:
						<#if header.paymentDate??> ${header.paymentDate?string('dd-MMM-yyyy')} </#if><br>
					</div>
				</#if>	
				</td>
			</tr>		
			<tr>
				<td>4</td>
				<td>Head Structure </td>
				<td>${headStructure}</td>
			</tr>
			<tr>
				<td>5</td>
				<td>Purpose </td>
				<td>${purpose}</td>
			</tr>
		</table>
		<p> <strong>Note: The Receipt is valid only after
			realisation of cheque/DD/PO</strong></p>

		<div class="height-100">
			<div class="rightAlign">
			<p style="line-height: 2.4;">
				Received by : <#if userName??> ${userName} </#if><br> Sign :<br> Designation : <#if designation??> ${designation} </#if>
			</p>
			</div>
		</div>

	</div>
	<!-- Payer Copy -->
	
	<div class="form-wrapper">
		<div class="rightAlign"><p>Payer Copy</p></div>
		<br>
		<div class="textCenter">
			<h3>
				<span style="text-decoration: underline">GTR 2000</span>
			</h3>
			<p>
				<span style="text-decoration: underline">Form No.05 - <em>Form of Receipt</em> <br> <br>
					(See rule 35)
				</span>
			</p>
		</div>
		<table>
			<tr>
				<td colspan="3"><strong>Office Name : </strong> ${officeName}
					</td>
			</tr>
			<tr>
				<td style="width: 50%"><strong>DDO No. :</strong> ${ddo}</td>
				<td colspan="2"><strong>Receipt No. :</strong> ${header.challanNumber} </td>
			</tr>
			<tr>
				<td style="width: 50%"><strong>Cardex No. :</strong> ${cardex}</td>
				<td><span style="margin-right: 30%;"><strong>Date
							: </strong> ${.now?string('dd-MMM-yyyy')} <strong>&nbsp;&nbsp;&nbsp;&nbsp;Time
							: </strong> ${.now?string('HH:mm:ss')}</span></td>
			</tr>
		</table>

		<br>
			<table class="table-bordered">
			<tr>
				<td>Sr No</td>
				<td colspan="2">Particulars</td>
			</tr>
			<tr>
				<td>1</td>
				<td>Payer Name  </td>
				<td style="width: 65%;">${header.payerName}</td>
			</tr>
			<tr>
				<td>2</td>
				<td>Amount <div class="rightAlign">
						in Rs. <br/> in Words 
					</div>
					 <br/>
				
					
				</td>
				<td>${totalFormattedAmount} <br/> ${totalInWord}</td>
			</tr>
			<tr>
				<td>3</td>
				<td>Mode of payment <br/>(Cash / Cheque / DD / Postal order) </td>
				<td>
				<#if header.paymentModeId == 1393>
					Cash
				<#elseif header.paymentModeId == 1394>
					<div>
						<strong>Cheque :</strong><br>					
						Bank Name: <#if bankName??> ${bankName} </#if> <br> Cheque No.: ${header.instrumentNo} <br>
						Cheque Date : <#if header.paymentDate??> ${header.paymentDate?string('dd-MMM-yyyy')} </#if> <br>
					</div>
				<#elseif  header.paymentModeId == 1396>
					<div>
						<strong>DD :</strong><br>					
						Bank Name: <#if bankName??> ${bankName} </#if> <br> DD No.: ${header.instrumentNo} <br>
						DD Date : <#if header.paymentDate??> ${header.paymentDate?string('dd-MMM-yyyy')} </#if><br>
					</div>
				<#elseif  header.paymentModeId == 1395>
					<div >
					<strong> Postal Order :</strong><br>				
						Postal Order No.: ${header.instrumentNo} <br> Postal Order Date.:
						<#if header.paymentDate??> ${header.paymentDate?string('dd-MMM-yyyy')} </#if><br>
					</div>
				</#if>	
				</td>
			</tr>		
			<tr>
				<td>4</td>
				<td>Head Structure </td>
				<td>${headStructure}</td>
			</tr>
			<tr>
				<td>5</td>
				<td>Purpose </td>
				<td>${purpose}</td>
			</tr>
		</table>
		<p> <strong>Note: The Receipt is valid only after
			realisation of cheque/DD/PO</strong></p>

		<div class="height-100">
			<div class="rightAlign">
			<p style="line-height: 2.4;">
				Received by : <#if userName??> ${userName} </#if><br> Sign :<br> Designation : <#if designation??> ${designation} </#if>
				</p>
			</div>
		</div>

	</div>
</body>
</html>