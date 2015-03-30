[#ftl]
<p>We have these animals:
<table border=1>
	<tr><th>Name<th>Price
	[#list animals as being]
	<tr>
		<td>
			[#if being.size = "large"]<b>[/#if]
			${being.name}
			[#if being.size = "large"]</b>[/#if]
		</td>${being.price} Euros
	[/#list]
	
</table>