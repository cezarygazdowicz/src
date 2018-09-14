package com.journaldev.retrofitintro;


import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import pl.droidsonroids.gif.GifImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView responseText;
    TextView cityResponse;
    EditText cityText;
    APIInterface apiInterface;
    String appid = "6940762269ce162ca2edfa9c277b3dfa";
    String city = "Bydgoszcz";
    Call<Weather> call;

    @Override
    protected void onStart() {
        super.onStart();

        setContentView(R.layout.activity_main);
        responseText = (TextView) findViewById(R.id.responseText);
        cityResponse = (TextView) findViewById(R.id.textView);
        cityText = (EditText) findViewById(R.id.cityPlain);
        apiInterface = APIClient.getClient().create(APIInterface.class);

        Button clickButton = (Button) findViewById(R.id.button);
        clickButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                city = cityText.getText().toString();
                call = apiInterface.doGetListResources(city, appid);
                call.enqueue(new Callback<Weather>() {
                    @Override
                    public void onResponse(Call<Weather> call, Response<Weather> response) {

                        String displayResponse = "";

                        Weather weather = response.body();
                        String name = weather.getName();
                        Weather.Main main = weather.getMain();
                        double temp = main.getTemp();
                        int tempInt = (int) temp;
                        int humidity = main.getHumidity();
                        Weather.Wind wind = weather.getWind();
                        double speed = wind.getSpeed();
                        int speedInt = (int) speed;
                        List<Weather.WeatherDescription> weatherDescriptions = weather.getWeatherDescription();
                        String description;
                        description = weatherDescriptions.get(0).mainDescription;


                        if(description.equals("Clear")) {
                            GifImageView imageView = (GifImageView) findViewById(R.id.gif);
                            imageView.setImageResource(R.drawable.clean);
                        }
                        else if(description.equals("Clouds")) {
                            GifImageView imageView = (GifImageView) findViewById(R.id.gif);
                            imageView.setImageResource(R.drawable.broken);
                        }
                        else if(description.equals("Rain")|| description.equals("Drizzle")) {
                            GifImageView imageView = (GifImageView) findViewById(R.id.gif);
                            imageView.setImageResource(R.drawable.rain);
                        }
                        else{
                            GifImageView imageView = (GifImageView) findViewById(R.id.gif);
                            imageView.setImageResource(R.drawable.tenor);
                        }

                        displayResponse +="Temperatura to:" + (tempInt-273)+ "\u00b0 \n" +"Prędkość wiatru: " + (speedInt*3600)/1000 +"km/h";


                        responseText.setText(displayResponse);
                        cityResponse.setText(name);

                    }

                    @Override
                    public void onFailure(Call<Weather> call, Throwable t) {
                        call.cancel();
                    }
                });
            }
        });

//
//        call = apiInterface.doGetListResources(city, appid);
//        call.enqueue(new Callback<Weather>() {
//            @Override
//            public void onResponse(Call<Weather> call, Response<Weather> response) {
//
//                String displayResponse = "";
//
//                Weather weather = response.body();
//                String name = weather.getName();
//                Weather.Main main = weather.getMain();
//                double temp = main.getTemp();
//                int tempInt = (int) temp;
//                int humidity = main.getHumidity();
//                Weather.Wind wind = weather.getWind();
//                double speed = wind.getSpeed();
//                List<Weather.WeatherDescription> weatherDescriptions = weather.getWeatherDescription();
//                String description;
//                description = weatherDescriptions.get(0).mainDescription;
//
//
//                if(description.equals("Clear")) {
//                    GifImageView imageView = (GifImageView) findViewById(R.id.gif);
//                    imageView.setImageResource(R.drawable.clean);
//                }
//                else if(description.equals("Clouds")) {
//                    GifImageView imageView = (GifImageView) findViewById(R.id.gif);
//                    imageView.setImageResource(R.drawable.broken);
//                }
//                else if(description.equals("Rain")|| description.equals("Drizzle")) {
//                    GifImageView imageView = (GifImageView) findViewById(R.id.gif);
//                    imageView.setImageResource(R.drawable.rain);
//                }
//                else{
//                    GifImageView imageView = (GifImageView) findViewById(R.id.gif);
//                    imageView.setImageResource(R.drawable.tenor);
//                }
//
//                displayResponse +="Temperatura to:" + (tempInt-273)+ "\u00b0 \n" +"Prędkość wiatru: " + (speed*3600)/1000 +"km/h";
//
//                responseText.setText(displayResponse);
//                cityResponse.setText(name);
//
//            }
//
//            @Override
//            public void onFailure(Call<Weather> call, Throwable t) {
//                call.cancel();
//            }
//        });
}

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
