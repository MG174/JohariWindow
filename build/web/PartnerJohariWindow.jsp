

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="/JohariWindow//CSS/styles.css" rel="stylesheet" type="text/css">
        <title>Johari Window</title>
    </head>
    <body>
        <h5>Your partners' johari window code: ${johari_window_id}</h5>
        <form method="POST" action="FinishJohariWindow">      
            <fieldset>      
                <legend>Select your partners' personality traits</legend>    
                <div class="row">
                    <div class="column">
                        <label><input type="checkbox" name="johari" value="extroverted">extroverted</label></br>
                        <label><input type="checkbox" name="johari" value="friendly">friendly</label><br>      
                        <label><input type="checkbox" name="johari" value="giving">giving</label><br>
                        <label><input type="checkbox" name="johari" value="happy">happy</label><br>      
                        <label><input type="checkbox" name="johari" value="helpful">helpful</label><br>      
                        <label><input type="checkbox" name="johari" value="idealistic">idealistic</label><br>
                        <label><input type="checkbox" name="johari" value="independent">independent</label><br>      
                        <label><input type="checkbox" name="johari" value="ingenious">ingenious</label><br>      
                        <label><input type="checkbox" name="johari" value="intelligent">intelligent</label><br>
                        <label><input type="checkbox" name="johari" value="introverted">introverted</label><br>      
                        <label><input type="checkbox" name="johari" value="kind">kind</label><br>      
                        <label><input type="checkbox" name="johari" value="knowledgeable">knowledgeable</label><br>
                        <label><input type="checkbox" name="johari" value="logical">logical</label><br>      
                        <label><input type="checkbox" name="johari" value="loving">loving</label><br>
                        <label><input type="checkbox" name="johari" value="brave">brave</label><br>      
                        <label><input type="checkbox" name="johari" value="bold">bold</label><br>      
                        <label><input type="checkbox" name="johari" value="adaptable">adaptable</label><br>
                        <label><input type="checkbox" name="johari" value="accepting">accepting</label><br>      
                        <label><input type="checkbox" name="johari" value="able">able</label><br>
                    </div>
                    <div class="column">
                        <label><input type="checkbox" name="johari" value="mature">mature</label><br>      
                        <label><input type="checkbox" name="johari" value="modest">modest</label><br>      
                        <label><input type="checkbox" name="johari" value="nervous">nervous</label><br>
                        <label><input type="checkbox" name="johari" value="observant">observant</label><br>      
                        <label><input type="checkbox" name="johari" value="organized">organized</label><br>      
                        <label><input type="checkbox" name="johari" value="patient">patient</label><br>
                        <label><input type="checkbox" name="johari" value="powerful">powerful</label><br>      
                        <label><input type="checkbox" name="johari" value="proud">proud</label><br>      
                        <label><input type="checkbox" name="johari" value="quiet">quiet</label><br>
                        <label><input type="checkbox" name="johari" value="reflective">reflective</label><br>      
                        <label><input type="checkbox" name="johari" value="relaxed">relaxed</label><br>      
                        <label><input type="checkbox" name="johari" value="religious">religious</label><br>
                        <label><input type="checkbox" name="johari" value="responsive">responsive</label><br>      
                        <label><input type="checkbox" name="johari" value="searching">searching</label><br>
                        <label><input type="checkbox" name="johari" value="calm">calm</label><br>      
                        <label><input type="checkbox" name="johari" value="caring">caring</label><br>      
                        <label><input type="checkbox" name="johari" value="cheerful">cheerful</label><br>
                        <label><input type="checkbox" name="johari" value="clever">clever</label><br>      
                        <label><input type="checkbox" name="johari" value="complex">complex</label><br>
                    </div>
                    <div class="column">
                        <label><input type="checkbox" name="johari" value="self-assertive">self-assertive</label><br>      
                        <label><input type="checkbox" name="johari" value="self-conscious">self-conscious</label><br>      
                        <label><input type="checkbox" name="johari" value="sensible">sensible</label><br>
                        <label><input type="checkbox" name="johari" value="sentimental">sentimental</label><br>      
                        <label><input type="checkbox" name="johari" value="shy">shy</label><br>      
                        <label><input type="checkbox" name="johari" value="silly">silly</label><br>
                        <label><input type="checkbox" name="johari" value="smart">smart</label><br>      
                        <label><input type="checkbox" name="johari" value="spontaneous">spontaneous</label><br>      
                        <label><input type="checkbox" name="johari" value="sympathetic">sympathetic</label><br>
                        <label><input type="checkbox" name="johari" value="tense">tense</label><br>      
                        <label><input type="checkbox" name="johari" value="trustworthy">trustworthy</label><br>      
                        <label><input type="checkbox" name="johari" value="warm">warm</label><br>
                        <label><input type="checkbox" name="johari" value="wise">wise</label><br>      
                        <label><input type="checkbox" name="johari" value="witty">witty</label><br>
                        <label><input type="checkbox" name="johari" value="confident">confident</label><br>      
                        <label><input type="checkbox" name="johari" value="dependable">dependable</label><br>      
                        <label><input type="checkbox" name="johari" value="dignified">dignified</label><br>
                        <label><input type="checkbox" name="johari" value="empathetic">empathetic</label><br>      
                        <label><input type="checkbox" name="johari" value="energetic">energetic</label><br>
                    </div>
                </div>      
                <br>      
                <input type="submit" value="Submit" />      
            </fieldset>      
        </form>
    </body>
</html>
