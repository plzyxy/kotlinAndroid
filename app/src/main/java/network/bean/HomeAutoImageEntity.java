package network.bean;

import java.util.List;

public class HomeAutoImageEntity {
	private int code;
	private String message;
	private List<AutoImage> data;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<AutoImage> getData() {
		return data;
	}

	public void setData(List<AutoImage> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "HomeAutoImageEntity{" +
				"code=" + code +
				", message='" + message + '\'' +
				", data=" + data +
				'}';
	}

	public class AutoImage  {

		private String banner_id;

		private String main_pic;

		private String type;

		private String banner_link;

		private String banner_name;

		@Override
		public String toString() {
			return "AutoImage{" +
					"banner_id='" + banner_id + '\'' +
					", main_pic='" + main_pic + '\'' +
					", type='" + type + '\'' +
					", banner_link='" + banner_link + '\'' +
					", banner_name='" + banner_name + '\'' +
					'}';
		}
//		private WebShare share;

		public String getBanner_id() {
			return banner_id;
		}

		public void setBanner_id(String banner_id) {
			this.banner_id = banner_id;
		}

//		public WebShare getShare() {
//			return share;
//		}

//		public void setShare(WebShare share) {
//			this.share = share;
//		}

		public String getMain_pic() {
			return main_pic;
		}

		public void setMain_pic(String main_pic) {
			this.main_pic = main_pic;
		}

		public String getBanner_link() {
			return banner_link;
		}

		public void setBanner_link(String banner_link) {
			this.banner_link = banner_link;
		}

		public String getBanner_name() {
			return banner_name;
		}

		public void setBanner_name(String banner_name) {
			this.banner_name = banner_name;
		}



		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

	}

}