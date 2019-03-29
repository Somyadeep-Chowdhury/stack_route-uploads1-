
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>KeepNote</title>
</head>
<body>
	<!-- Create a form which will have text boxes for Note ID, title, content and status along with a Send 
		 button. Handle errors like empty fields -->

		 <form action= "/saveNote" method="post">
		    NoteID:  <input type="textbox" name="noteId" required/><br>
		    Note Title:  <input type="textbox" name="noteTitle" required/><br>
		    Note Content:  <input type="textbox" name="noteContent" required/><br>
		    Note Status:   <select name="noteStatus" required>
                            <option value="active">Active</option>
                            <option value="disabled">Disabled</option>
                          </select> <br>
		    <input type="submit" name="submit" />
		 </form>


	<!-- display all existing notes in a tabular structure with Id, Title,Content,Status, Created Date and Action -->

	<table>
            <tr>
                <th>NoteId</th>
                <th>NoteTitle</th>
                <th>NoteContent</th>
                <th>NoteStatus</th>
                <th>NoteCreationDate</th>
             </tr>
            <c:forEach items="${notes}" var="note">
             <tr>
                <td>${note.noteId}</td>
                <td>${note.getNoteTitle()}</td>
                <td>${note.getNoteContent()}</td>
                <td>${note.getNoteStatus()}</td>
                <td>${note.getCreatedAt()}</td>
               <!-- <td><a href="deleteNote?noteId=${note.noteId}">Delete</a></td>-->
               <td><form method="post" action="/deleteNote">
                       <input type="hidden" value="${note.noteId}"  name="noteId"/>
                       <button type="submit" >Delete</button>
                    </form>
                </td>
             </tr>
             </c:forEach>
        </table>



</body>
</html>