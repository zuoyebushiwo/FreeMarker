<#assign x = "something">
${indexOf("met", x)}
${indexOf("foo", x)}

foo
<@upper>
bar
<#-- 这里允许使用所有的FTL -->
<#list ["red", "green", "blue"] as color>
${color}
</#list>
baaz
</@upper>
wombat

<#assign x = 1>
<@repeat count=4>
Test ${x}
<#assign x = x + 1>
</@repeat>
<@repeat count=3 hr=true>
Test
</@repeat>
<@repeat count=3; cnt>
${cnt}. Test
</@repeat>

${theObject.name}
${theObject.price}
${theObject.sin(123)}

<#setting locale="it_IT">
<#setting number_format="0.####">

