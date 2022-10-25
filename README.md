# irrigation-system

This is a solution for Task required for hiring process by BanQue Misr

the solution is consits of two parts 
- part to handle adding new plot and configure it 
- part for handle sensor read and handle it to call other service (mocked)


you could find all the code in irrigation system it's consits of
- models 
- controller
- services
- repository
- DTO
- enums

you will find two contrrols for each part 

you can add plot throw calling

```
 POST "http/{host}/api/plot"
  {
    private float timeSlot;
    private  float amountOfWater;
    private String moistureSensorId;
    private  String irrigateSensorId;
  
  }
  
  ```
  and you could configure it by call 
  ```
  PUT "http/localhost:8080/api/plot/{plotId}"
  {
    @NotNull
    private float timeSlot;
    @NotNull
    private  float amountOfWater;
    @NotNull
    private String moistureSensorId;
    @NotNull
    private  String irrigateSensorId;
  }
  
  ```
  and sensor service could call sensor api to start irrigation by 
  
  ```
  notice sensorId here mean moistureSensorId that's responsble for telling if the land need water or not 
  
  POST "http/localhost:8080/api/sensor/{sensorId}"
  {}
  ```
  
  the last api will be call for mock function to return if irrigationSensor is available or not so it will retrey every 10 sec if not 
  and after finishing retry calls it will call for alret system
  
  you should setup mongodb on your device or contact with mongodb cluster by chaning the url creditionals in 
  resources/application.yml
  
  and using spring boot 
  
  
  thank you! 
  
