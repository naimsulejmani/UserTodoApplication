CREATE DATABASE UserTodoDb;
GO

USE UserTodoDb;
GO

/*
    private int id;
    private String name;
    private String description;
    private LocalDate deadline;
    private boolean isFinished;
    private Color color;

*/

CREATE TABLE TodoItems (
    Id INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
    [Name] NVARCHAR(100) NOT NULL,
    [Description] NVARCHAR(MAX) NULL,
    Deadline DATE NOT NULL DEFAULT (GETDATE()),
    IsFinished BIT NOT NULL DEFAULT(0),
    Color NVARCHAR(50) NULL
    )