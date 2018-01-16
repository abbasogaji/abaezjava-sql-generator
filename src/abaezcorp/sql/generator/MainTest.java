package abaezcorp.sql.generator;

public class MainTest {

	public static void main(String[] args){
		SqlGenerator sql = new SqlGenerator();
		String data;

			//data = sql.table("Books").update("name", "age", "sex").to("abbas", "20", "male").where("username", "abase96").get();
			//data = sql.table("Books").insert("name", "age").values("abbas", "20", "male").get();
			data = sql.table("Books").delete().where("abbas", "male").get();
			System.out.println(data);


	}
}
