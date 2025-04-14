package com.metacoding.blogv1.board;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

@Import(BoardRepository.class)
@DataJpaTest
public class BoardRepositoryTest {
    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void selectAll_test() {
        // 1. given

        // 2. when
        List<Board> boardList = boardRepository.findAll();
        // 3. eye
        for (Board board : boardList) {
            System.out.println(board.getTitle());
        }
    }

    @Test
    public void selectOne_test() {
        // 1. given
        int boardId = 1;
        // 2. when
        Board board = boardRepository.findById(boardId);
        // 3. eye
        System.out.println(board.getTitle());
    }

    @Test
    public void save_test() {
        // 1. given
        List<Board> boardList = boardRepository.findAll();
        System.out.println("추가 전 크기 : " + boardList.size());
        String title = "test1";
        String content = "test content";
        // 2. when
        boardRepository.insert(title, content);
        // 3. eye
        List<Board> boardList2 = boardRepository.findAll();
        System.out.println("추가 후 크기 : " + boardList2.size());
    }

    @Test
    public void delete_test() {
        // 1. given
        List<Board> boardList = boardRepository.findAll();
        System.out.println("삭제 전 크기 : " + boardList.size());
        int boardId = 1;
        // 2. when
        boardRepository.deleteById(boardId);
        // 3. eye
        List<Board> boardList2 = boardRepository.findAll();
        System.out.println("삭제 후 크기 : " + boardList2.size());
    }

    @Test
    public void update_test() {
        // 1. given
        int boardId = 2;
        String title = "test2";
        String content = "test content2";
        // 2. when
        boardRepository.update(boardId, title, content);
        // 3. eye
        Board updatedBoard = boardRepository.findById(boardId);
        System.out.println("수정 후 board title : " + updatedBoard.getTitle());
        System.out.println("수정 후 board content : " + updatedBoard.getContent());
    }
}
