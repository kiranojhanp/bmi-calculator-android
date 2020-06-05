# BMI Calculator



## Output

![This is what application looks like](https://i.imgur.com/L4toFA5.jpg)

## Creating an UI

![UI](https://i.imgur.com/XJeVAYV.png)
Constraint layout was used to build the UI.

## Getting value from textfields

In MainActivity.java, We are going to make variables of textfield and textview first:
```java
final EditText weight = (EditText) findViewById(R.id.editTextweight);
final EditText height = (EditText) findViewById(R.id.editTextheight);
final TextView result = (TextView) findViewById(R.id.textView3);
```

then we're going to get the values and convert them to string
```java
String wt = weight.getText().toString();
String ht = height.getText().toString();
```

a null validation is performed
```java
 // validation
 if (TextUtils.isEmpty(wt)){
 weight.setError("Please enter your weight");
 weight.requestFocus();
 return;
 }

 if (TextUtils.isEmpty(ht)){
 height.setError("Please enter your weight");
 height.requestFocus();
 return;
 }
```
If the value aren't null, It is sent for calculation.

```java
// Get the user values and parse them to float
float high = Float.parseFloat(ht);
float weigh = Float.parseFloat(wt);

 // Calculate BMI
 float bmiValue = calculateBMI(weigh, high);
 String bmiInterpretation = interpretBMI(bmiValue);

```
As we can see, Above Calculation uses two methods calculateBMI
and interpretBMI. These methods are created as below.

#### calculateBMI method
```java
private float calculateBMI(float weight, float height){
        return (float) (weight / (height * height));
    }

```

#### interpretBMI method
```java
// Interpret what BMI means
    private String interpretBMI(float bmiValue){
        String output = "";
        if (bmiValue < 18.5){
            output =  "Underweight";
        }
        else if(bmiValue < 24.9){
            output = "Healthy weight";
        }
        else if(bmiValue < 29.9){
            output = "Over weight";
        }
        else {
            output = "extremely obese";
        }
        return output;
    }
```










In this way, BMI Calculator was created

## Youtube video
[YOUTUBE](https://youtu.be/9HFhgAK9N5M)

