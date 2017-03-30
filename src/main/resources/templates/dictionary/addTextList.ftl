<#include "/parts/header.ftl">
<script>
    function deleteClick(id) {
        var table = document.getElementById("wordsTable");
        table.deleteRow(id+1);
    }

    function editClick(id) {
        document.getElementById("original"+id).removeAttribute("readonly");
        document.getElementById("translated"+id).removeAttribute("readonly");
        document.getElementById("editBtn"+id).style.visibility = "hidden";
        document.getElementById("saveBtn"+id).style.visibility = "visible";
    }

    function saveClick(id) {
        document.getElementById("original"+id).setAttribute("readonly", "readonly");
        document.getElementById("translated"+id).setAttribute("readonly", "readonly");
        document.getElementById("editBtn"+id).style.visibility = "visible";
        document.getElementById("saveBtn"+id).style.visibility = "hidden";
    }

    function addClick(){
        var orig_obj = document.getElementsByClassName("orig_word");
        var trans_obj = document.getElementsByClassName("trans_word");
        var words = new Array();
        for(var i = 0; i < orig_obj.length; i++) {
            var word= new Object();
            word.original = orig_obj.item(i).value;
            word.translated = trans_obj.item(i).value;
            words.push({"original" : word.original, "translated" : word.translated});
        }
        var json = JSON.stringify({"words" : words});
        document.getElementById("wordsString").value = json;
    }
    $(function () {
        $('.orig_word').on('keyup keypress', function(e) {
            if (e.keyCode == 8 || e.keyCode == 46) {}
            else
            {
                var letters='абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ';
                return ((letters.indexOf(String.fromCharCode(e.which))!=-1));
            }
        });

        $('.trans_word').on('keyup keypress', function(e) {
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
    <div class="col-xs-14">
        <table class="table table-striped" id="wordsTable">
            <tr>
                <th>original</th>
                <th>translated</th>
                <th> </th>
                <th> </th>
                <th> </th>
            </tr>
            <#list words as word>
            <tr id="${word_index}">
                <td><input class="form-control orig_word"
                           type="text"
                           id="original${word_index}"
                           name="original"
                           value="${word.original}"
                           readonly/></td>
                <td><input class="form-control trans_word"
                           type="text"
                           id="translated${word_index}"
                           name="translated"
                           value="${word.translated}"
                           readonly/></td>
                <td><button id="deleteBtn${word_index}"
                            class="btn btn-danger btn-lg small delete-btn"
                            onclick="deleteClick(${word_index})">Удалить</button></td>
                <td><button id="editBtn${word_index}"
                            class="btn btn-primary btn-lg small edit-btn"
                            name="editBtn"
                            onclick="editClick(${word_index})">Изменить</button></td>
                <td><button id="saveBtn${word_index}"
                            class="btn btn-success btn-lg small save-btn"
                            style="visibility: hidden"
                            onclick="saveClick(${word_index})">Сохранить</button></td>
            </tr>
            </#list>
        </table>
        <form name="wordsString" role="form" action="/dictionary/addTextList" method="post" class="form-horizontal">
            <input id="wordsString" type="text" name="wordsString" class="form-control" style="visibility: hidden">
            <button type="submit"
                    class="btn btn-success btn-lg small"
                    id="submit"
                    onclick="addClick()">Добавить</button>
        </form>
    </div>
</div>
<br>
<br>
<a class="button" href="/">На главную</a>

<#include "/parts/footer.ftl">