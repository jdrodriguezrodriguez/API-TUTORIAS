package com.example.demo.models.commons;

public class Response <T>{

		private T object;
		private String mensaje;
		
		
		public Response(String mensaje) {

			this.mensaje = mensaje;
		}
		
		
		public Response(T object, String mensaje) {
			this.object = object;
			this.mensaje = mensaje;
		}
		
		
		public T getObject() {
			return object;
		}
		public void setObject(T object) {
			this.object = object;
		}
		public String getMensaje() {
			return mensaje;
		}
		public void setMensaje(String mensaje) {
			this.mensaje = mensaje;
		}
		
		
}
