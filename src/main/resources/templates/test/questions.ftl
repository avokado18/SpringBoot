<#include "/parts/header.ftl">
<script>
    function answerClick() {
        var trans_obj = document.getElementsByClassName("word_translated");
        var answers = document.getElementsByClassName("answer");
        var count = 0;
        for (var i = 0; i <trans_obj.length; i++){
            var trans = trans_obj.item(i).value;
            var ans = answers.item(i).value;
            if (trans.toLowerCase() === ans.toLowerCase()) {
                count++;
                answers.item(i).style.borderColor = "green";
                answers.item(i).setAttribute("readonly", "readonly");
            } else {
                answers.item(i).style.borderColor = "red";
                trans_obj.item(i).style.visibility = "visible";
                answers.item(i).setAttribute("readonly", "readonly")
            }
        }
        if (count != 15){
            document.getElementById("right").innerHTML = "Правильный ответ";
        }
        document.getElementById("answer").style.visibility = "hidden";
        document.getElementById("count").style.visibility = "visible";
        document.getElementById("count").innerHTML = document.getElementById("count").innerHTML + count;
        if (document.getElementById("oneMore").value == 1) {
            document.getElementById("index").style.visibility = "visible";
        }
    }
</script>
<div class="row">
    <div>
        <table class="table table-striped">
            <tr>
                <th>Слово</th>
                <th>Перевод</th>
                <th id="right"> </th>
            </tr>
            <#list words as word>
                <tr>
                    <td class="word_original">${word.original!}</td>
                    <td><input class="form-control answer"
                               type="text"/></td>
                    <td><input class="form-control word_translated"
                               type="text"
                               value="${word.translated!}"
                               style="visibility: hidden"
                               readonly/></td>
                </tr>
            </#list>
        </table>
        <label id="count" for="count" style="visibility: hidden">Правильных ответов: </label>
        <button class="btn btn-success btn-lg small"
                id="answer"
                onclick="answerClick()">Ответить</button>
        <br>
        <br>
        <a class="button" href="/">На главную</a>
        <br>
        <input id="oneMore" type="text" style="visibility: hidden" value="${oneMore}"/>
        <br>
        <a id="index" class="button" href="/test/questions" style="visibility: hidden">Пройти еще раз</a>
    </div>
</div>
<#include "/parts/footer.ftl">