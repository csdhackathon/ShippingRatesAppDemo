![Pitney Bowes](https://github.com/csdhackathon/LocationAPIsApp/blob/master/PitneyBowes_Logo.jpg)

# Pitney Bowes SMB Challenge 2017

### Sample App showcasing consumption of [Pitney Bowes Shipping Rates APIs](http://www.pitneybowes.com/us/developer/shipping-apis.html)

### For Changes in Project & Running
1. Checkout the code
2. Go to path *ShippingAPIDemo/app/build.gradle* and replace your own API Key & Secret 
```
    buildConfigField "String", "APP_KEY", "\"SOME_API_KEY\""
    buildConfigField "String", "SECRET", "\"SOME_SECRET\""
```
3. In case you want to switch server from sandbox then in same file mentioned above you will need to change - 

```
    buildConfigField "String", "BASE_URL", "\"https://api-sandbox.pitneybowes.com/\""
```
Replace **https://api-sandbox.pitneybowes.com/** with desired server base path. (Make sure it ends with one **/**)

4. Run the application from Android Studio.

5. On Successfull Build & Run process you will see Splash Screen with Pitney Bowes Logo, It will try to connect the server to get the Access Token.

6. After Splash completion and Token generated then next screen will come with tilte **Shipping API Demo** with two buttons -
 - One is for getting Shipping Country List
 - Another one is to demonstrate Shipment Rate API

7. Now you can select API demo and also you check the logs for REST APIs.

