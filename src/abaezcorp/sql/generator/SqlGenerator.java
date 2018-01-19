/* Database CRUD SQL generator
 *
 * Author: Abbas Yunusa Ogaji
 * Date: 15 January 2018
 * E-mail: abbasogaji@gmail.com
 * ----------------------------------
 * CONSTRAINTS
 * ----------------------------------
 * 1- no multiple where clauses
 * 2- no join clauses
 * 3- no order clauses

 */
package abaezcorp.sql.generator;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class SqlGenerator {

	private String table, sql;
	private final String[] operators = {"=", "!=", ">", "<", ">=", "<="};
	private final String[] orderType = {"ASC", "DESC"};
	private List<String> updateColumns, updateValues;
	private List<String> insertColumns, insertValues;

	//THE BELOW IS THE FIRST METHOD TO BE CALLED
	public SqlGenerator table(String tbl){
		table = tbl;
		return this;
	}

	//THE BELOW IS CALLED AFTER CALLING THE TABLE() METHOD
	//THE BELOW IS CALLED AFTER CALLING THE TABLE() METHOD
	public SqlGenerator insert(String ...columns){
		insertColumns = new ArrayList<String>();
		for(String x:columns){
			insertColumns.add(x);
		}
		return this;
	}

	//THE BELOW IS CALLED AFTER THE CALLING THE INSERT() METHOD
	public SqlGenerator values(String ...values){

		insertValues = new ArrayList<String>();
		for(String x:values){
			insertValues.add(x);
		}
		sql = sqlizeInsert();
		return this;
	}
	//THE BELOW IS CALLED INSIDE THE  'VALUES()' METHOD
	private String sqlizeInsert(){
		if(insertColumns.size() == insertValues.size()){
						String col = "";
						String val = "";
						int total = insertValues.size();
						for(int x=0; x<total; x++){
							if((total-1) == x){
								col += insertColumns.get(x)+"";
								val +=  "'"+insertValues.get(x)+"'";
							}else{
								col += insertColumns.get(x)+", ";
								val +=  "'"+insertValues.get(x)+"', ";
							}
						}
						return "INSERT INTO "+table+" ("+col+") VALUES ("+val+")";

		}else{

				System.err.println(new WrongColumnValueRatioException("A Wrong Column to value ratio Exception Occured"));
				System.exit(0);
				return null;
		}

	}

	//THE BELOW IS CALLED AFTER CALLING THE TABLE() METHOD
	public SqlGenerator select(){
		sql = "SELECT * FROM "+table;
		return this;
	}
	public SqlGenerator select(String ...type){

			String typ = "";
			List<String> list = new ArrayList<String>();
			for(String x:type){
				list.add(x);
			}
			int listSize = list.size();
			for(int y=0; y<listSize; y++){
				if((listSize-1) == y){
					typ += list.get(y)+"";
				}else{
					typ += list.get(y)+", ";
				}

			}
			sql = "SELECT "+typ+" FROM "+table;

		return this;
	}
	//THE BELOW IS CALLED AFTER CALLING THE UPDATE(), SELECT(), INSERT() OR DELETE() METHOD
	public SqlGenerator whereEqual(String columnName, String val){
		sql += " WHERE "+columnName+" = '"+val+"'";
		return this;
	}
	//THE BELOW CAN BE CALLED AFTER WHERE() METHOD
	public SqlGenerator orWhereEqual(String columnName, String val){
		sql += " OR "+columnName+" = '"+val+"'";
		return this;
	}
	//THE BELOW IS CALLED AFTER WHERE() METHOD
	public SqlGenerator andWhereEqual(String columnName, String val){
		sql += " AND "+columnName+" = '"+val+"'";
		return this;
	}
	//THE BELOW IS CALLED FOR ADVANCED WHERE() CLAUSE
	public SqlGenerator where(String columnName, String operator, String val){
		if(Arrays.asList(operators).contains(operator)){
			sql += " WHERE "+columnName+" "+operator+" '"+val+"'";
			return this;
		}else{
			System.err.println(new WrongWhereClauseOperatorException("A Wrong WHERE clause operator Exception Occured"));
			System.exit(0);
			return null;

		}
	}//THE BELOW CAN BE CALLED AFTER WHERE() METHOD
	public SqlGenerator orWhere(String columnName, String operator, String val){
		if(Arrays.asList(operators).contains(operator)){
			sql += " OR "+columnName+" "+operator+" '"+val+"'";
			return this;
		}else{
			System.err.println(new WrongWhereClauseOperatorException("A Wrong Column to value ratio Exception Occured"));
			System.exit(0);
			return null;

		}

	}
	//THE BELOW IS CALLED AFTER WHERE() METHOD
	public SqlGenerator andWhere(String columnName, String operator, String val){
		if(Arrays.asList(operators).contains(operator)){
			sql += " AND "+columnName+" "+operator+" '"+val+"'";
			return this;
		}else{
			System.err.println(new WrongWhereClauseOperatorException("A Wrong Column to value ratio Exception Occured"));
			System.exit(0);
			return null;

		}
	}
	//THE BELOW IS CALLED AFTER WHERE() METHOD
	public SqlGenerator orderBy(String columnName, String keyword){
		if(Arrays.asList(orderType).contains(keyword)){
			sql += " ORDER BY "+columnName+" "+keyword+"";
			return this;
		}else{
			System.err.println(new WrongOrderTypeException("A Wrong Order - Type Exception Occured"));
			System.exit(0);
			return null;

		}
	}
	//THE BELOW IS CALLED AFTER CALLING THE TABLE() METHOD
	public SqlGenerator delete(){
		sql = "DELETE FROM "+table+"";
		return this;
	}
	//THE BELOW IS CALLED AFTER CALLING THE TABLE() METHOD
	public SqlGenerator update(String ...columns){
		updateColumns = new ArrayList<String>();
		for(String x:columns){
			updateColumns.add(x);
		}

		return this;
	}

	//THE BELOW IS CALLED AFTER CALLING THE UPDATE() METHOD
	public SqlGenerator to(String ...values){
		updateValues = new ArrayList<String>();
		for(String x:values){
			updateValues.add(x);
		}
		sql = sqlizeUpdate();
		return this;
	}
	//THE BELOW IS CALLED INSIDE THE  'TO()' METHOD
	private String sqlizeUpdate(){
		if(updateColumns.size() == updateValues.size()){
						String set = " ";
						int total = updateValues.size();
						for(int x=0; x<total; x++){
							if((total-1) == x){
								set += updateColumns.get(x)+" = '"+updateValues.get(x)+"'";
							}else{
								set += updateColumns.get(x)+" = '"+updateValues.get(x)+"', ";
							}
						}
						String sql = "UPDATE "+table+" SET "+set;
						return sql;
		}else{

			System.err.println(new WrongColumnValueRatioException("A Wrong Column to value ratio Exception Occured"));
			System.exit(0);
			return null;

		}

	}
	//THE BELOW IS CALLED AFTER CALLING THE INSERT(), SELECT(), DELETE(), OR WHERE() METHOD
	public String get(){
		return sql;
	}



}
