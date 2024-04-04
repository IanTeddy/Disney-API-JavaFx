package org.example.disneyapi;

import java.net.HttpURLConnection;
import java.net.URL;

// class for handling images
public class ImageHandler {
    // a method to check image URL is valid. If not, return default
    public static String checkImageUrl(String originalImage){
        // assign original image url to imageUrl
        String imageUrl = originalImage;

        // Start some check: if image URL is not null or not empty,
        if (imageUrl != null && !imageUrl.isEmpty()) {
            // check weather image URL return actual image or Not Found
            try {
                // create a URL object from the image URL string
                URL url = new URL(imageUrl);

                // open a connection to the URL
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("HEAD"); // use HEAD method to check without downloading the entire image

                // get the HTTP response code
                int responseCode = connection.getResponseCode();

                // check if the response code indicates the image is not found (404)
                if (responseCode == HttpURLConnection.HTTP_NOT_FOUND) {
                    // display default image instead
                    imageUrl = "images/default-movie.png";
                }
                // close the connection
                connection.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            // If imageUrl is null or empty, display default image
            imageUrl = "images/default-movie.png";
        }
        // return imageUrl
        return imageUrl;
    }
}
