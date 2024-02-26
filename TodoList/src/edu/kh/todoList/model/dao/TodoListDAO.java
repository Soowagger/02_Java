package edu.kh.todoList.model.dao;

import java.util.List;

import edu.kh.todoList.model.dto.Todo;

// DAO (Data Access Object) : 
// 데이터가 저장된 파일/DB/외부 장치에 접근하는 역할
public interface TodoListDAO {
	
	/** TodoList를 파일로 저장하는 메서드
	 * 
	 */
	void saveFile() throws Exception;
	
	/** 할 일 목록 반환 DAO
	 * @return todoList
	 */
	List<Todo> todoListFullView();
	
	/** 전달 받은 index번째 todo를 반환 DAO
	 * @param index
	 * @return index번째 todo, 없으면 null
	 */
	Todo todoDetailView(int index);

	int todoAdd(Todo todo) throws Exception;

	boolean todoComplete(int index) throws Exception;

	/** 할 일 수정 DAO
	 * @param index
	 * @param title
	 * @param content
	 * @return 성공 true, 실패 false
	 */
	boolean todoUpdate(int index, String title, String content) throws Exception;

	/** 할 일 삭제 DAO
	 * @param index
	 * @return 성공 시 삭제된 할일(Todo) 반환
	 * 			인덱스 범위 초과로 실패 시 null 반환
	 */
	Todo todoDelete(int index) throws Exception;
	
	
}
