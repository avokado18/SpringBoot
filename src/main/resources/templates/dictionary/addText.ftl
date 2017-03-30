<#include "/parts/header.ftl">
<form name="textToTranslate" role="form" action="/dictionary/addText" method="post" class="form-horizontal">
    <label for="text">Введите текст: </label>
    <textarea id="text" class="form-control" required="true" name="textToTranslate"></textarea>
    <br>
    <button type="submit" class="btn btn-primary btn-lg small" id="submit" >Добавить</button>
</form>

<br>
<br>
<a class="button" href="/">На главную</a>

<#include "/parts/footer.ftl">