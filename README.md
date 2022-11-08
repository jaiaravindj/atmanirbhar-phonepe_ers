# MMT - HeadSpin Hackathon

A simple flow of login & searching a Hotel for any date, 2 rooms with 2 adults & 2 children each, applying certain filters & listing down all the available Hotels with minimum tarriff of INR 1,000 & User Rating of above 4.0. The flow needs to select 5th entry in the Hotel & assert all the information entered. The flow also makes 2 special requests for the booking. The Project executes on Mobile Native Application (Android) using Appium. The Project Directory also consists of the .apk file for MMT Native Mobile Application.


## Installation

Clone the Project as a Maven Project in IntelliJ from the Root Directory - 'atmanirbhar-phonepe_ers'


### Prerequisites

* Software Stack required for the Project Execution:
1) JDK 1.8 with Environment Variables set
2) IntelliJ
3) TestNg Plugin in IntelliJ
4) Maven Plugin on OS with Environment Variables set
5) Appium Server with Allow Override Session Capability
6) ADB Bundle with Environment Variables set

* Hardware Stack required for the Project Execution:
1) OnePlus 6 Phone (or any Android Device) with unlocked Developer Mode
2) MacOS or Windows OS based Machine


## config.Properties

* androidDeviceName -> Give the deviceName from the [HeadSpin](https://www.headspin.io)
* appPackage -> Package name of the app under test
* appActivity -> Launch Activity name of the app under test
* serverUrl -> Give the serverUrl(driverUrl from HeadSpin) else the default is the localhost
* username -> EmailId for Login
* password -> Password for login
* noOfRooms -> Number rooms needed to be booked (This will handle the step 5)
* totalGuests -> Total Guests needed to be added (This will handle the step 5)


## HeadSpin Integration

* We tried to use https://<api-token>@api-dev.headspin.io/v0/devices/automation-config & get the devices, select the first device that is available for the given geo location. 
But since we were not able to get the state of the device, it was mostly failing. So we decided to go ahead with adding the driverUrl in Config.properties. You can check our code on HeadSpinHelper.java.


## Running the tests

* For Mobile App
Start the Appium Server & connect Android MobilePhone to the Machine in PTP Mode.
Run 'adb devices' command on the terminal to make sure it is connected.
Directly execute the 'MMTMobile.xml' TestNg Suite for execution on Native MMT App.


### And coding style tests

The script tries to do a Login & later searches the 5th Hotel in the list for a particular Room & Guest Count.
Then apply 2 filters viz. Minimum Price as INR 1,000, User Rating above 4.0 & validate it.
Further, select a room & capture all the data. Enter guest details & validate the data. 


## Challenges

* We had problems in login flow as most of the time the password button gets hidden as we are retrying the flow again and again. We have handled with and without password
* Getting the state of the device in headSpin was something we expected. There was a work around given which we couldn't accomadate in the stipulated time.


## Built with

* [Appium](http://appium.io/docs/en/about-appium/) - The mobile framework used
* [Maven](https://maven.apache.org/) - Dependency Management


## Authors

* Jai Aravind [Senior SDET - PhonePe]
* Sumed Khicha [Senior SDET]




