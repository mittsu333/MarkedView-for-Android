$(function() {

    marked.setOptions({
        langPrefix: ''
    });

//    var renderer = new marked.Renderer();

    function escSub(text){
        var result = text.match(/~.*?~/g);
        if(result == null){
            return text;
        }

        $.each(result, function(index, val){
            var escapedText = val.replace(/~/, '<sub>');
            escapedText = escapedText.replace(/~/, '</sub>');
            var reg = new RegExp(val, 'g');
            text = text.replace(reg, escapedText);
        });

        return text;
    }

    function escSup(text){
        var result = text.match(/\^.*?\^/g);
        if(result == null){
            return text;
        }

        $.each(result, function(index, val){
            var escapedText = val.replace(/\^/, '<sup>');
            escapedText = escapedText.replace(/\^/, '</sup>');
            val = val.replace(/\^/g, '\\^');
            var reg = new RegExp(val, 'g');
            text = text.replace(reg, escapedText);
        });

        return text;
    }

    preview = function setMarkdown(md_text){
        if(md_text == ""){
          return false;
        }

        md_text = md_text.replace(/\\n/g, "\n");
        md_text = escSub(md_text);
        md_text = escSup(md_text);

//        alert(md_text);

        // markdown html
        var md_html = marked(md_text);

//        var md_html = marked(md_text,
//                function (err, content) {
//                    if (err) throw err;
//                    alert(content);
//                });

//        alert(md_html);


        $('#preview').html(md_html);

        $('pre code').each(function(i, block){
            hljs.highlightBlock(block);
        });
    };
});