package v3;

public class Main {
        public static int port = 8090;
        public static void main(String[] args) {

//		// start http server
		SimpleHttpServer httpServer = new SimpleHttpServer();
		httpServer.Start(port);

            // start https server
//           SimpleHttpsServer httpsServer = new SimpleHttpsServer();
//           httpsServer.Start(port);
        }
}

