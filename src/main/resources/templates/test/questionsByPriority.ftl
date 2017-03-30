<#include "/parts/header.ftl">

<div class="row">
    <div class="col-md-6 col-md-offset-3">
        <form name="priority" role="form" action="/test/questionsByPriority" method="post" class="form-horizontal">
            <label for="priority">Введите приоритет слова в словаре: </label>
            <input id="priority"
                   type="number"
                   min="1" max="5"
                   class="form-control input-sm"
                   required="true"
                   name="priority" title="Приоритет - целое число в промежутке от 1 до 5."/>
            <br>
            <button type="submit" class="btn btn-primary btn-lg small" id="submit" >Сгенерировать тест</button>
        </form>
        <br>
        <br>
        <a class="button" href="/">На главную</a>
    </div>
</div>


<#include "/parts/footer.ftl">
