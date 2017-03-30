<#include "/parts/header.ftl">
<div class="row">
    <div>
        <table class="table table-striped">
            <tr>
                <th>original</th>
                <th>translated</th>
                <th>priority</th>
            </tr>
        <#list words as word>
            <tr>
                <td class="editable-td word-original">${word.original!}</td>
                <td class="editable-td word-translated">${word.translated!}</td>
                <td class="editable-td word-priority">${word.priority!}</td>
            </tr>
        </#list>
        </table>
    </div>
</div>
<br>
<br>
<a class="button" href="/">На главную</a>
<#include "/parts/footer.ftl">