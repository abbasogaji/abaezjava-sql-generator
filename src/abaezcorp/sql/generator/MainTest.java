package abaezcorp.sql.generator;

public class MainTest {

	public static void main(String[] args){
		SqlGenerator sql = new SqlGenerator();
		String data;

			//data = sql.table("users").update("name", "age", "sex").to("abbas", "20", "male").where("username", "abase96").get();
			//data = sql.table("users").insert("name", "age").values("abbas", "20", "male").get();
			//data = sql.table("users").select().where("username", "abcd").get();
			//data = sql.table("users").select("first_name", "last_name").where("username", "abcd").get();
			data = sql.table("users").delete().where("abbas", "male").get();
			System.out.println(data);


	}
}
