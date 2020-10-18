Create Database PDSACourseWork;

USE PDSACourseWork;

CREATE TABLE Branches (
	BranchId int NOT NULL,
	BranchName nvarchar(MAX)  NOT NULL,
	Location nvarchar(MAX)  NOT NULL
	PRIMARY KEY (BranchId),	
);

CREATE TABLE Distances (
	DistanceId int IDENTITY(1,1) NOT NULL,
	FromBranchId int  NOT NULL,
	ToBranchId int  NOT NULL,
	Distance numeric(18,2) NOT NULL,
	PRIMARY KEY (DistanceId),
	CONSTRAINT FK_BranchesDistances_FromBranch FOREIGN KEY (FromBranchId)
    REFERENCES Branches(BranchId),
	CONSTRAINT FK_BranchesDistances_ToBranch FOREIGN KEY (ToBranchId)
    REFERENCES Branches(BranchId)
);
