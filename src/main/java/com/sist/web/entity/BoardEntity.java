package com.sist.web.entity;
import java.util.*;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
// save(), delete()
// findByNo(int no) WHERE no=1
@Data
@Entity(name="board")
public class BoardEntity {
	@Id
	private int no;
	private int hit;	
	private String name,subject,content,pwd;
	private Date regdate;
}
