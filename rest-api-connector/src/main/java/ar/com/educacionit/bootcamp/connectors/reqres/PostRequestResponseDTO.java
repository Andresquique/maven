package ar.com.educacionit.bootcamp.connectors.reqres;

public class PostRequestResponseDTO {

	
	    private String name;
	    private String job;
	    private Long id;
	    private String createdAt;
		
	    
	    public PostRequestResponseDTO() {
	    }


		public String getName() {
			return name;
		}


		public String getJob() {
			return job;
		}


		public Long getId() {
			return id;
		}


		public String getCreatedAt() {
			return createdAt;
		}


		public void setName(String name) {
			this.name = name;
		}


		public void setJob(String job) {
			this.job = job;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public void setCreatedAt(String createdAt) {
			this.createdAt = createdAt;
		}


		@Override
		public String toString() {
			return "PostRequestResponseDTO [name=" + name + ", job=" + job + ", id=" + id + ", createdAt=" + createdAt
					+ "]";
		}
	    
	    
}
