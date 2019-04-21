import com.example.SharedLibraryConstants
@Grab(group='org.apache.httpcomponents', module='httpclient', version='4.5.8')
import org.apache.httpcomponents.httpclient  

def call() {
  def jsonSlurper = new JsonSlurper()
  def httpclient  = HttpClients.createDefault();
  def httpGet     = new HttpGet('http://api.icndb.com/jokes/random');
  def response    = httpclient.execute(httpGet);


  try {
    def jokeResp = jsonSlurper.parseText(response.getEntity().getContent())
  } finally {
    response.close();
  }

  return jokeResp.value.joke
}
