<#include "/parts/header.ftl">
<script>
    $(function () {
        $('#orig').on('keyup keypress', function(e) {
            if (e.keyCode == 8 || e.keyCode == 46) {}
            else
            {
                var letters='абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ';
                return ((letters.indexOf(String.fromCharCode(e.which))!=-1));
            }
        });

        $('#tran').on('keyup keypress', function(e) {
            if (e.keyCode == 8 || e.keyCode == 46) {}
            else
            {
                var letters='abcdefghijklmnopqrstuvwxyzABCDEFGHILKLMNOPQRSTUVWXYZ';
                return ((letters.indexOf(String.fromCharCode(e.which))!=-1));
            }
        });
    });

</script>
<div class="row">
    <div class="col-md-6 col-md-offset-3">
        <form name="word" role="form" action="/dictionary/addOneWord" method="post" class="form-horizontal">
            <label for="orig">Введите слово: </label>
            <input id="orig" type="text" class="form-control" name="original" required="true"/>
            <br>
            <label for="tran">Введите перевод: </label>
            <input id="tran" type="text" class="form-control" name="translated" required="true"/>
            <br>
            <button type="submit" class="btn btn-primary btn-lg small" id="submit">Добавить</button>
        </form>
        <br>
        <br>
        <a class="button" href="/">На главную</a>
    </div>
</div>
<#include "/parts/footer.ftl">