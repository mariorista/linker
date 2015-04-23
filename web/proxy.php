<?php
header('Content-Type: text/xml');

//$symbol = $_GET["symbol"];
//$page = $_GET["page"];
//$key = $_GET["key"];

//if ($key==null){
$url = 'http://dbpedia.org/snorql/?query=PREFIX+dbo%3A+%3Chttp%3A%2F%2Fdbpedia.org%2Fontology%2F%3E+%0D%0APREFIX+%3A+%3Chttp%3A%2F%2Fdbpedia.org%2Fresource%2F%3E+%0D%0A%0D%0ASELECT++%3Fpred+%3Fo+%0D%0AWHERE%7B+%0D%0A%0D%0A+%7B%3ASkanderbeg++%3Fpred+%3Fo.+%0D%0AFILTER+%28lang+%28%3Fo%29+%3D%22en%22%29+.%7D+%0D%0A%0D%0AUNION++%0D%0A%0D%0A+%7B%3ASkanderbeg++dbo%3AwikiPageExternalLink+%3Fo+.%7D+%0D%0A%0D%0A%7D+';
//'http://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=cb6f26b3da96fe96e09bfbd09223aee2&text='.$symbol.'&page='.$page.'&format=rest';
//}
/*else{
    $url = 'http://api.flickr.com/services/rest/?method=flickr.photos.search&api_key='.key.'&text='.$symbol.'&page='.$page.'&format=rest';
}*/
$ch = curl_init();

// set URL and other appropriate options
curl_setopt($ch, CURLOPT_URL, $url);
curl_setopt($ch, CURLOPT_HEADER, 0);

// grab URL and pass it to the browser
curl_exec($ch);

// close cURL resource, and free up system resources
curl_close($ch);

?>


