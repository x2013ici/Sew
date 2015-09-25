use [SewDevel]
GO

select * from Country
truncate table Country

---- Country
INSERT INTO [SewDevel].[dbo].[Country]
           ([Name]
           ,[Code]
           ,[Status]
           ,[CreatedOn]
           ,[UpdatedOn])
     VALUES
           ('United States'
           ,'USA'
           ,1
           ,getDate()
           ,getDate())
GO
INSERT INTO [SewDevel].[dbo].[Country]
           ([Name]
           ,[Code]
           ,[Status]
           ,[CreatedOn]
           ,[UpdatedOn])
     VALUES
           ('Canada'
           ,'CA'
           ,1
           ,getDate()
           ,getDate())
GO

INSERT INTO [SewDevel].[dbo].[Country]
           ([Name]
           ,[Code]
           ,[Status]
           ,[CreatedOn]
           ,[UpdatedOn])
     VALUES
           ('Bangladesh'
           ,'BD'
           ,1
           ,getDate()
           ,getDate())
GO
----------------------------------------------
-- Address
select * from [Address]

INSERT INTO [SewDevel].[dbo].[Address]
           ([Address]
           ,[Street]
           ,[CountryId]
           ,[City]
           ,[State]
           ,[Zipcode]
           ,[Status]
           ,[CreatedOn]
           ,[UpdatedOn])
     VALUES
           ('Twelve'
           ,'Maclellan Street'
           ,1
           ,'Antigonish'
           ,'NS'
           ,'B2G1V5'
           ,1
           ,getDate()
           ,getDate())
GO

INSERT INTO [SewDevel].[dbo].[Address]
           ([Address]
           ,[Street]
           ,[CountryId]
           ,[City]
           ,[State]
           ,[Zipcode]
           ,[Status]
           ,[CreatedOn]
           ,[UpdatedOn])
     VALUES
           ('15'
           ,'Maclellan Street'
           ,1
           ,'Antigonish'
           ,'NS'
           ,'B2G4V5'
           ,1
           ,getDate()
           ,getDate())
GO

INSERT INTO [SewDevel].[dbo].[Address]
           ([Address]
           ,[Street]
           ,[CountryId]
           ,[City]
           ,[State]
           ,[Zipcode]
           ,[Status]
           ,[CreatedOn]
           ,[UpdatedOn])
     VALUES
           ('54B'
           ,'St. Marry Street'
           ,1
           ,'Antigonish'
           ,'NS'
           ,'B2G2A5'
           ,1
           ,getDate()
           ,getDate())
GO
--- ProviderSignupRequest

select * from ProviderSignupRequest

INSERT INTO [SewDevel].[dbo].[ProviderSignupRequest]
           ([Name]
           ,[Phone]
           ,[Email]
           ,[Fax]
           ,[AddressId]
           ,[Status]
           ,[CreatedOn]
           ,[UpdatedOn])
     VALUES
           ('Center for Logic and Information'
           ,'9028721113'
           ,'cli@stfx.ca'
           ,'4828721113'
           ,1
           ,1
           ,getDate()
           ,getDate())
GO

INSERT INTO [SewDevel].[dbo].[ProviderSignupRequest]
           ([Name]
           ,[Phone]
           ,[Email]
           ,[Fax]
           ,[AddressId]
           ,[Status]
           ,[CreatedOn]
           ,[UpdatedOn])
     VALUES
           ('St. Francis Xavier University'
           ,'9028721113'
           ,'stfx@stfx.ca'
           ,'4828723331'
           ,1
           ,1
           ,getDate()
           ,getDate())
GO
-- ProviderSignupRequester
INSERT INTO [SewDevel].[dbo].[ProviderSignupRequester]
           ([FirstName]
           ,[LastName]
           ,[UserName]
           ,[Password]
           ,[Phone]
           ,[Email]
           ,[DOB]
           ,[Gender]
           ,[AddressId]
           ,[Status]
           ,[CreatedOn]
           ,[UpdatedOn])
     VALUES
           ('Wendy'
           ,'MacCaull'
           ,'wendy'
           ,'stfx12'
           ,'902-872-1113'
           ,'wendy@stfx.ca'
           ,getDate()
           ,'Female'
           ,1
           ,1
           ,getdate()
           ,getdate())
GO

INSERT INTO [SewDevel].[dbo].[ProviderSignupRequester]
           ([FirstName]
           ,[LastName]
           ,[UserName]
           ,[Password]
           ,[Phone]
           ,[Email]
           ,[DOB]
           ,[Gender]
           ,[AddressId]
           ,[Status]
           ,[CreatedOn]
           ,[UpdatedOn])
     VALUES
           ('Rhandra'
           ,'MacDonald'
           ,'rhandra'
           ,'stfx12'
           ,'902-872-1113'
           ,'rhandra@stfx.ca'
           ,getDate()
           ,'Female'
           ,1
           ,1
           ,getdate()
           ,getdate())
GO

INSERT INTO [SewDevel].[dbo].[ProviderSignupRequester]
           ([FirstName]
           ,[LastName]
           ,[UserName]
           ,[Password]
           ,[Phone]
           ,[Email]
           ,[DOB]
           ,[Gender]
           ,[AddressId]
           ,[Status]
           ,[CreatedOn]
           ,[UpdatedOn])
     VALUES
           ('Mostafijur'
           ,'Rahman'
           ,'Hira'
           ,'stfx12'
           ,'902-872-1113'
           ,'x2013ici@stfx.ca'
           ,getDate()
           ,'Male'
           ,1
           ,1
           ,getdate()
           ,getdate())
GO

-- UserType
select * from UserType

INSERT INTO [SewDevel].[dbo].[UserType]
           ([Name]
           ,[Description]
           ,[Status]
           ,[CreatedOn]
           ,[UpdatedOn])
     VALUES
           ('Super Admin'
           ,'Will be added later'
           ,1
           ,getdate()
           ,getdate())
GO

INSERT INTO [SewDevel].[dbo].[UserType]
           ([Name]
           ,[Description]
           ,[Status]
           ,[CreatedOn]
           ,[UpdatedOn])
     VALUES
           ('Company Admin'
           ,'Will be added later'
           ,1
           ,getdate()
           ,getdate())
GO

INSERT INTO [SewDevel].[dbo].[UserType]
           ([Name]
           ,[Description]
           ,[Status]
           ,[CreatedOn]
           ,[UpdatedOn])
     VALUES
           ('Company User'
           ,'Will be added later'
           ,1
           ,getdate()
           ,getdate())
GO

INSERT INTO [SewDevel].[dbo].[UserType]
           ([Name]
           ,[Description]
           ,[Status]
           ,[CreatedOn]
           ,[UpdatedOn])
     VALUES
           ('End User'
           ,'Will be added later'
           ,1
           ,getdate()
           ,getdate())
GO

-- Provider
select * from Provider

INSERT INTO [SewDevel].[dbo].[Provider]
           ([Name]
           ,[Phone]
           ,[Email]
           ,[Fax]
           ,[AddressId]
           ,[Status]
           ,[CreatedOn]
           ,[CreatedBy]
           ,[UpdatedOn]
           ,[UpdatedBy])
     VALUES
           ('Center for Logic and Information'
           ,'902872113'
           ,'cli@stfx.ca'
           ,'4828721113'
           ,1
           ,1
           ,getdate()
           ,1
           ,getdate()
           ,1)
GO

INSERT INTO [SewDevel].[dbo].[Provider]
           ([Name]
           ,[Phone]
           ,[Email]
           ,[Fax]
           ,[AddressId]
           ,[Status]
           ,[CreatedOn]
           ,[CreatedBy]
           ,[UpdatedOn]
           ,[UpdatedBy])
     VALUES
           ('St. Francis Xavier University'
           ,'902872113'
           ,'stfx@stfx.ca'
           ,'4828721113'
           ,1
           ,1
           ,getdate()
           ,1
           ,getdate()
           ,1)
GO
-------------------------------------------------
-- User

select * from [User]
truncate table [User]

INSERT INTO [SewDevel].[dbo].[User]
           ([FirstName]
           ,[LastName]
           ,[UserName]
           ,[Email]
           ,[Password]
           ,[DOB]
           ,[ContactNumber]
           ,[UploadPath]
           ,[ProfilePicture]
           ,[ProfilePictureThumbnail]
           ,[Gender]
           ,[UserTypeId]
           ,[ProviderId]
           ,[AddressId]
           ,[Status]
           ,[CreatedOn]
           ,[CreatedBy]
           ,[UpdatedOn]
           ,[UpdatedBy])
     VALUES
           ('Wendy'
           ,'MacCaull'
           ,'wendy'
           ,'wendy@stfx.ca'
           ,'stfx12'
           ,getdate()
           ,'902-872-1113'
           ,'N/A'
           ,null
           ,null
           ,'Female'
           ,1
           ,1
           ,1
           ,1
           ,getdate()
           ,1
           ,getdate()
           ,1)
GO

INSERT INTO [SewDevel].[dbo].[User]
           ([FirstName]
           ,[LastName]
           ,[UserName]
           ,[Email]
           ,[Password]
           ,[DOB]
           ,[ContactNumber]
           ,[UploadPath]
           ,[ProfilePicture]
           ,[ProfilePictureThumbnail]
           ,[Gender]
           ,[UserTypeId]
           ,[ProviderId]
           ,[AddressId]
           ,[Status]
           ,[CreatedOn]
           ,[CreatedBy]
           ,[UpdatedOn]
           ,[UpdatedBy])
     VALUES
           ('Rhandra'
           ,'MacDonald'
           ,'rhandra'
           ,'rhandra@stfx.ca'
           ,'stfx12'
           ,getdate()
           ,'902-872-1113'
           ,'N/A'
           ,null
           ,null
           ,'Female'
           ,1
           ,1
           ,1
           ,1
           ,getdate()
           ,1
           ,getdate()
           ,1)
GO

INSERT INTO [SewDevel].[dbo].[User]
           ([FirstName]
           ,[LastName]
           ,[UserName]
           ,[Email]
           ,[Password]
           ,[DOB]
           ,[ContactNumber]
           ,[UploadPath]
           ,[ProfilePicture]
           ,[ProfilePictureThumbnail]
           ,[Gender]
           ,[UserTypeId]
           ,[ProviderId]
           ,[AddressId]
           ,[Status]
           ,[CreatedOn]
           ,[CreatedBy]
           ,[UpdatedOn]
           ,[UpdatedBy])
     VALUES
           ('Mostafijur'
           ,'Rahman'
           ,'Hira'
           ,'x2013ici@stfx.ca'
           ,'stfx12'
           ,getdate()
           ,'902-872-1113'
           ,'N/A'
           ,null
           ,null
           ,'Female'
           ,1
           ,1
           ,1
           ,1
           ,getdate()
           ,1
           ,getdate()
           ,1)
GO
------------------------------------------------------------
-- UserLoginSession
INSERT INTO [SewDevel].[dbo].[UserLoginSession]
           ([UserId]
           ,[SessionToken]
           ,[DeviceMacId]
           ,[Status]
           ,[CreatedOn]
           ,[UpdatedOn])
     VALUES
           (4
           ,'MQAAAwAA=='
           ,null
           ,1
           ,getdate()
           ,getdate())
GO


INSERT INTO [SewDevel].[dbo].[UserLoginSession]
           ([UserId]
           ,[SessionToken]
           ,[DeviceMacId]
           ,[Status]
           ,[CreatedOn]
           ,[UpdatedOn])
     VALUES
           (5
           ,'MQAAAwAA=='
           ,null
           ,1
           ,getdate()
           ,getdate())
GO


INSERT INTO [SewDevel].[dbo].[UserLoginSession]
           ([UserId]
           ,[SessionToken]
           ,[DeviceMacId]
           ,[Status]
           ,[CreatedOn]
           ,[UpdatedOn])
     VALUES
           (6
           ,'MQAAAwAA=='
           ,null
           ,1
           ,getdate()
           ,getdate())
GO
------------------------------------------------------------
-- Cef3 Service
select * from [Service]

INSERT INTO [SewDevel].[dbo].[Service]
           ([ServiceName]
           ,[Description]
           ,[FolderName]
           ,[ProviderId]
           ,[CreatedBy]
           ,[UpdatedBy]
           ,[Status]
           ,[CreatedOn]
           ,[UpdatedOn])
     VALUES
           ('Cef3 Service'
           ,'Cef3 Service Description'
           ,'http://test.biocomalert.com/docs/services/cef3/'
           ,1
           ,1
           ,1
           ,1
           ,getdate()
           ,getdate())
GO

select * from ServiceDetails

-- Service File
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (1
           ,'Cef3Service.owl'
           ,'application/rdf+xml'
           ,'http://test.biocomalert.com/docs/services/cef3/Cef3Service.owl'
           ,'http://test.biocomalert.com/docs/services/cef3/Cef3Service.owl'
           ,1
           ,1,getdate())
GO

-- Profile File
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (1
           ,'Cef3Profile.owl'
           ,'application/rdf+xml'
           ,'http://test.biocomalert.com/docs/services/cef3/Cef3Profile.owl'
           ,'http://test.biocomalert.com/docs/services/cef3/Cef3Profile.owl'
           ,2,1,getdate())
GO

-- QoS Profile
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (1
           ,'Cef3QoSProfile.owl'
           ,'application/rdf+xml'
           ,'http://test.biocomalert.com/docs/services/cef3/Cef3QoSProfile.owl'
           ,'http://test.biocomalert.com/docs/services/cef3/Cef3QoSProfile.owl'
           ,3,1,getdate())
GO

-- Process File
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (1
           ,'Cef3Process.owl'
           ,'application/rdf+xml'
           ,'http://test.biocomalert.com/docs/services/cef3/Cef3Process.owl'
           ,'http://test.biocomalert.com/docs/services/cef3/Cef3Process.owl'
           ,4,1,getdate())
GO

-- Grounding File
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (1
           ,'Cef3Grounding.owl'
           ,'application/rdf+xml'
           ,'http://test.biocomalert.com/docs/services/cef3/Cef3Grounding.owl'
           ,'http://test.biocomalert.com/docs/services/cef3/Cef3Grounding.owl'
           ,5,1,getdate())
GO

-- Wsdl Grounding
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (1
           ,'Cef3Grounding.wsdl'
           ,'application/wsdl+xml'
           ,'http://test.biocomalert.com/docs/services/cef3/Cef3Grounding.wsdl'
           ,'http://test.biocomalert.com/docs/services/cef3/Cef3Grounding.wsdl'
           ,6,1,getDate())
GO
---------------------------------------------------------------------------------
-- Ambrox Service
INSERT INTO [SewDevel].[dbo].[Service]
           ([ServiceName]
           ,[Description]
           ,[FolderName]
           ,[ProviderId]
           ,[CreatedBy]
           ,[UpdatedBy]
           ,[Status]
           ,[CreatedOn]
           ,[UpdatedOn])
     VALUES
           ('Ambrox Service'
           ,'Ambrox Service Description'
           ,'http://test.biocomalert.com/docs/services/ambrox/'
           ,1
           ,1
           ,1
           ,1
           ,getdate()
           ,getdate())
GO

-- Service File
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (2
           ,'AmbroxService.owl'
           ,'application/rdf+xml'
           ,'http://test.biocomalert.com/docs/services/ambrox/AmbroxService.owl'
           ,'http://test.biocomalert.com/docs/services/ambrox/AmbroxService.owl'
           ,1,1,getdate())
GO

-- Profile File
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (2
           ,'AmbroxProfile.owl'
           ,'application/rdf+xml'
           ,'http://test.biocomalert.com/docs/services/ambrox/AmbroxProfile.owl'
           ,'http://test.biocomalert.com/docs/services/ambrox/AmbroxProfile.owl'
           ,2,1,getDate())
GO

-- QoS Profile
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (2
           ,'AmbroxQoSProfile.owl'
           ,'application/rdf+xml'
           ,'http://test.biocomalert.com/docs/services/ambrox/AmbroxQoSProfile.owl'
           ,'http://test.biocomalert.com/docs/services/ambrox/AmbroxQoSProfile.owl'
           ,3,1,getDate())
GO

-- Process File
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (2
           ,'AmbroxProcess.owl'
           ,'application/rdf+xml'
           ,'http://test.biocomalert.com/docs/services/ambrox/AmbroxProcess.owl'
           ,'http://test.biocomalert.com/docs/services/ambrox/AmbroxProcess.owl'
           ,4,1,getDate())
GO

-- Grounding File
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (2
           ,'AmbroxGrounding.owl'
           ,'application/rdf+xml'
           ,'http://test.biocomalert.com/docs/services/ambrox/AmbroxGrounding.owl'
           ,'http://test.biocomalert.com/docs/services/ambrox/AmbroxGrounding.owl'
           ,5,1,getDate())
GO

-- Wsdl Grounding
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (2
           ,'AmbroxGrounding.wsdl'
           ,'application/wsdl+xml'
           ,'http://test.biocomalert.com/docs/services/ambrox/AmbroxGrounding.wsdl'
           ,'http://test.biocomalert.com/docs/services/ambrox/AmbroxGrounding.wsdl'
           ,6,1,getDate())
GO
--------------------------------------------------------------------------------------------
-- Gmax Service
INSERT INTO [SewDevel].[dbo].[Service]
           ([ServiceName]
           ,[Description]
           ,[FolderName]
           ,[ProviderId]
           ,[CreatedBy]
           ,[UpdatedBy]
           ,[Status]
           ,[CreatedOn]
           ,[UpdatedOn])
     VALUES
           ('Gmax Service'
           ,'Gmax Service Description'
           ,'http://test.biocomalert.com/docs/services/gmax/'
           ,1
           ,1
           ,1
           ,1
           ,getdate()
           ,getdate())
GO

-- Service File
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (3
           ,'GmaxService.owl'
           ,'application/rdf+xml'
           ,'http://test.biocomalert.com/docs/services/gmax/GmaxService.owl'
           ,'http://test.biocomalert.com/docs/services/gmax/GmaxService.owl'
           ,1,1,getdate())
GO

-- Profile
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (3
           ,'GmaxProfile.owl'
           ,'application/rdf+xml'
           ,'http://test.biocomalert.com/docs/services/gmax/GmaxProfile.owl'
           ,'http://test.biocomalert.com/docs/services/gmax/GmaxProfile.owl'
           ,2,1,getDate())
GO

-- QoS Profile
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (3
           ,'GmaxQoSProfile.owl'
           ,'application/rdf+xml'
           ,'http://test.biocomalert.com/docs/services/gmax/GmaxQoSProfile.owl'
           ,'http://test.biocomalert.com/docs/services/gmax/GmaxQoSProfile.owl'
           ,3,1,getDate())
GO

-- Process
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (3
           ,'GmaxProcess.owl'
           ,'application/rdf+xml'
           ,'http://test.biocomalert.com/docs/services/gmax/GmaxProcess.owl'
           ,'http://test.biocomalert.com/docs/services/gmax/GmaxProcess.owl'
           ,4,1,getdate())
GO

-- Grounding
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (3
           ,'GmaxGrounding.owl'
           ,'application/rdf+xml'
           ,'http://test.biocomalert.com/docs/services/gmax/GmaxGrounding.owl'
           ,'http://test.biocomalert.com/docs/services/gmax/GmaxGrounding.owl'
           ,5,1,getDate())
GO

-- Wsdl Grounding
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (3
           ,'GmaxGrounding.wsdl'
           ,'application/wsdl+xml'
           ,'http://test.biocomalert.com/docs/services/gmax/GmaxGrounding.wsdl'
           ,'http://test.biocomalert.com/docs/services/gmax/GmaxGrounding.wsdl'
           ,6,1,getdate())
GO
-------------------------------------------------------------------------
-- Napa Service
INSERT INTO [SewDevel].[dbo].[Service]
           ([ServiceName]
           ,[Description]
           ,[FolderName]
           ,[ProviderId]
           ,[CreatedBy]
           ,[UpdatedBy]
           ,[Status]
           ,[CreatedOn]
           ,[UpdatedOn])
     VALUES
           ('Napa Service'
           ,'Napa Service Description'
           ,'http://test.biocomalert.com/docs/services/napa/'
           ,1
           ,1
           ,1
           ,1
           ,getdate()
           ,getdate())
GO

-- Service File
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (4
           ,'NapaService.owl'
           ,'application/rdf+xml'
           ,'http://test.biocomalert.com/docs/services/napa/NapaService.owl'
           ,'http://test.biocomalert.com/docs/services/napa/NapaService.owl'
           ,1,1,getDate())
GO

-- Profile
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (4
           ,'NapaProfile.owl'
           ,'application/rdf+xml'
           ,'http://test.biocomalert.com/docs/services/napa/NapaProfile.owl'
           ,'http://test.biocomalert.com/docs/services/napa/NapaProfile.owl'
           ,2,1,getdate())
GO

-- QoS Profile
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (4
           ,'NapaQoSProfile.owl'
           ,'application/rdf+xml'
           ,'http://test.biocomalert.com/docs/services/napa/NapaQoSProfile.owl'
           ,'http://test.biocomalert.com/docs/services/napa/NapaQoSProfile.owl'
           ,3,1,getdate())
GO

-- Process File
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (4
           ,'NapaProcess.owl'
           ,'application/rdf+xml'
           ,'http://test.biocomalert.com/docs/services/napa/NapaProcess.owl'
           ,'http://test.biocomalert.com/docs/services/napa/NapaProcess.owl'
           ,4,1,getdate())
GO

-- Grounding
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (4
           ,'NapaGrounding.owl'
           ,'application/rdf+xml'
           ,'http://test.biocomalert.com/docs/services/napa/NapaGrounding.owl'
           ,'http://test.biocomalert.com/docs/services/napa/NapaGrounding.owl'
           ,5,1,getdate())
GO

-- Wsdl Grounding
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (4
           ,'NapaGrounding.wsdl'
           ,'application/wsdl+xml'
           ,'http://test.biocomalert.com/docs/services/napa/NapaGrounding.wsdl'
           ,'http://test.biocomalert.com/docs/services/napa/NapaGrounding.wsdl'
           ,6,1,getdate())
GO
----------------------------------------------------------------------------------
-- Serape
INSERT INTO [SewDevel].[dbo].[Service]
           ([ServiceName]
           ,[Description]
           ,[FolderName]
           ,[ProviderId]
           ,[CreatedBy]
           ,[UpdatedBy]
           ,[Status]
           ,[CreatedOn]
           ,[UpdatedOn])
     VALUES
           ('Serape Service'
           ,'Serape Service Description'
           ,'http://test.biocomalert.com/docs/services/serape/'
           ,1
           ,1
           ,1
           ,1
           ,getdate()
           ,getdate())
GO

-- Service File
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (5
           ,'SerapeService.owl'
           ,'application/rdf+xml'
           ,'http://test.biocomalert.com/docs/services/serape/SerapeService.owl'
           ,'http://test.biocomalert.com/docs/services/serape/SerapeService.owl'
           ,1,1,getdate())
GO

-- Profile
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (5
           ,'SerapeProfile.owl'
           ,'application/rdf+xml'
           ,'http://test.biocomalert.com/docs/services/serape/SerapeProfile.owl'
           ,'http://test.biocomalert.com/docs/services/serape/SerapeProfile.owl'
           ,2,1,getdate())
GO

-- QoS Profile
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (5
           ,'SerapeQoSProfile.owl'
           ,'application/rdf+xml'
           ,'http://test.biocomalert.com/docs/services/serape/SerapeQoSProfile.owl'
           ,'http://test.biocomalert.com/docs/services/serape/SerapeQoSProfile.owl'
           ,3,1,getdate())
GO

-- Process
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (5
           ,'SerapeProcess.owl'
           ,'application/rdf+xml'
           ,'http://test.biocomalert.com/docs/services/serape/SerapeProcess.owl'
           ,'http://test.biocomalert.com/docs/services/serape/SerapeProcess.owl'
           ,4,1,getdate())
GO

-- Grounding
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (5
           ,'SerapeGrounding.owl'
           ,'application/rdf+xml'
           ,'http://test.biocomalert.com/docs/services/serape/SerapeGrounding.owl'
           ,'http://test.biocomalert.com/docs/services/serape/SerapeGrounding.owl'
           ,5,1,getdate())
GO

-- Wsdl Grounding
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (5
           ,'SerapeGrounding.wsdl'
           ,'application/wsdl+xml'
           ,'http://test.biocomalert.com/docs/services/serape/SerapeGrounding.wsdl'
           ,'http://test.biocomalert.com/docs/services/serape/SerapeGrounding.wsdl'
           ,6,1,getdate())
GO
--------------------------------Discover Patient Service------------------------------------------------------------------------------------------
INSERT INTO [SewDevel].[dbo].[Service]
           ([ServiceName]
           ,[Description]
           ,[FolderName]
           ,[ProviderId]
           ,[CreatedBy]
           ,[UpdatedBy]
           ,[Status]
           ,[CreatedOn]
           ,[UpdatedOn])
     VALUES
           ('Discover Patient Service'
           ,'Discover Patient Service Description'
           ,'http://test.biocomalert.com/docs/services/patient/'
           ,1
           ,1
           ,1
           ,1
           ,getdate()
           ,getdate())
GO

-- Service File
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (6
           ,'DiscoverPatientService.owl'
           ,'application/rdf+xml'
           ,'http://test.biocomalert.com/docs/services/patient/DiscoverPatientService.owl'
           ,'http://test.biocomalert.com/docs/services/patient/DiscoverPatientService.owl'
           ,1,1,getdate())
GO

-- Profile
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (6
           ,'DiscoverPatientProfile.owl'
           ,'application/rdf+xml'
           ,'http://test.biocomalert.com/docs/services/patient/DiscoverPatientProfile.owl'
           ,'http://test.biocomalert.com/docs/services/patient/DiscoverPatientProfile.owl'
           ,2,1,getdate())
GO

-- QoS Profile
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (6
           ,'DiscoverPatientQoSProfile.owl'
           ,'application/rdf+xml'
           ,'http://test.biocomalert.com/docs/services/patient/DiscoverPatientQoSProfile.owl'
           ,'http://test.biocomalert.com/docs/services/patient/DiscoverPatientQoSProfile.owl'
           ,3,1,getdate())
GO

-- Process
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (6
           ,'DiscoverPatientProcess.owl'
           ,'application/rdf+xml'
           ,'http://test.biocomalert.com/docs/services/patient/DiscoverPatientProcess.owl'
           ,'http://test.biocomalert.com/docs/services/patient/DiscoverPatientProcess.owl'
           ,4,1,getdate())
GO

-- Grounding
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (6
           ,'DiscoverPatientGrounding.owl'
           ,'application/rdf+xml'
           ,'http://test.biocomalert.com/docs/services/patient/DiscoverPatientGrounding.owl'
           ,'http://test.biocomalert.com/docs/services/patient/DiscoverPatientGrounding.owl'
           ,5,1,getdate())
GO

-- Wsdl Grounding
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (6
           ,'DiscoverPatientGrounding.wsdl'
           ,'application/wsdl+xml'
           ,'http://test.biocomalert.com/docs/services/patient/DiscoverPatientGrounding.wsdl'
           ,'http://test.biocomalert.com/docs/services/patient/DiscoverPatientGrounding.wsdl'
           ,6,1,getdate())
GO
--------------------------------Discover Physician Service------------------------------------------------------------------------------------------
INSERT INTO [SewDevel].[dbo].[Service]
           ([ServiceName]
           ,[Description]
           ,[FolderName]
           ,[ProviderId]
           ,[CreatedBy]
           ,[UpdatedBy]
           ,[Status]
           ,[CreatedOn]
           ,[UpdatedOn])
     VALUES
           ('Discover Physician Service'
           ,'Discover Physician Service Description'
           ,'http://test.biocomalert.com/docs/services/physician/'
           ,1
           ,1
           ,1
           ,1
           ,getdate()
           ,getdate())
GO

-- Service File
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (7
           ,'DiscoverPhysicianService.owl'
           ,'application/rdf+xml'
           ,'http://test.biocomalert.com/docs/services/physician/DiscoverPhysicianService.owl'
           ,'http://test.biocomalert.com/docs/services/physician/DiscoverPhysicianService.owl'
           ,1,1,getdate())
GO

-- Profile
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (7
           ,'DiscoverPhysicianProfile.owl'
           ,'application/rdf+xml'
           ,'http://test.biocomalert.com/docs/services/physician/DiscoverPhysicianProfile.owl'
           ,'http://test.biocomalert.com/docs/services/physician/DiscoverPhysicianProfile.owl'
           ,2,1,getdate())
GO

-- QoS Profile
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (7
           ,'DiscoverPhysicianQoSProfile.owl'
           ,'application/rdf+xml'
           ,'http://test.biocomalert.com/docs/services/physician/DiscoverPhysicianQoSProfile.owl'
           ,'http://test.biocomalert.com/docs/services/physician/DiscoverPhysicianQoSProfile.owl'
           ,3,1,getdate())
GO

-- Process
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (7
           ,'DiscoverPhysicianProcess.owl'
           ,'application/rdf+xml'
           ,'http://test.biocomalert.com/docs/services/physician/DiscoverPhysicianProcess.owl'
           ,'http://test.biocomalert.com/docs/services/physician/DiscoverPhysicianProcess.owl'
           ,4,1,getdate())
GO

-- Grounding
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (7
           ,'DiscoverPhysicianGrounding.owl'
           ,'application/rdf+xml'
           ,'http://test.biocomalert.com/docs/services/physician/DiscoverPhysicianGrounding.owl'
           ,'http://test.biocomalert.com/docs/services/physician/DiscoverPhysicianGrounding.owl'
           ,5,1,getdate())
GO

-- Wsdl Grounding
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (7
           ,'DiscoverPhysicianGrounding.wsdl'
           ,'application/wsdl+xml'
           ,'http://test.biocomalert.com/docs/services/physician/DiscoverPhysicianGrounding.wsdl'
           ,'http://test.biocomalert.com/docs/services/physician/DiscoverPhysicianGrounding.wsdl'
           ,6,1,getdate())
GO
--------------------------------Appointment Service--------------------------------------------------------------------------------
INSERT INTO [SewDevel].[dbo].[Service]
           ([ServiceName]
           ,[Description]
           ,[FolderName]
           ,[ProviderId]
           ,[CreatedBy]
           ,[UpdatedBy]
           ,[Status]
           ,[CreatedOn]
           ,[UpdatedOn])
     VALUES
           ('Appointment Service'
           ,'Appointment Service Description'
           ,'http://test.biocomalert.com/docs/services/appoint/'
           ,1
           ,1
           ,1
           ,1
           ,getdate()
           ,getdate())
GO

-- Service File
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (8
           ,'AppointService.owl'
           ,'application/rdf+xml'
           ,'http://test.biocomalert.com/docs/services/appoint/AppointService.owl'
           ,'http://test.biocomalert.com/docs/services/appoint/AppointService.owl'
           ,1,1,getdate())
GO

-- Profile
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (8
           ,'AppointProfile.owl'
           ,'application/rdf+xml'
           ,'http://test.biocomalert.com/docs/services/appoint/AppointProfile.owl'
           ,'http://test.biocomalert.com/docs/services/appoint/AppointProfile.owl'
           ,2,1,getdate())
GO

-- QoS Profile
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (8
           ,'AppointQoSProfile.owl'
           ,'application/rdf+xml'
           ,'http://test.biocomalert.com/docs/services/appoint/AppointQoSProfile.owl'
           ,'http://test.biocomalert.com/docs/services/appoint/AppointQoSProfile.owl'
           ,3,1,getdate())
GO

-- Process
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (8
           ,'AppointProcess.owl'
           ,'application/rdf+xml'
           ,'http://test.biocomalert.com/docs/services/appoint/AppointProcess.owl'
           ,'http://test.biocomalert.com/docs/services/appoint/AppointProcess.owl'
           ,4,1,getdate())
GO

-- Grounding
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (8
           ,'AppointGrounding.owl'
           ,'application/rdf+xml'
           ,'http://test.biocomalert.com/docs/services/appoint/AppointGrounding.owl'
           ,'http://test.biocomalert.com/docs/services/appoint/AppointGrounding.owl'
           ,5,1,getdate())
GO

-- Wsdl Grounding
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (8
           ,'AppointGrounding.wsdl'
           ,'application/wsdl+xml'
           ,'http://test.biocomalert.com/docs/services/appoint/AppointGrounding.wsdl'
           ,'http://test.biocomalert.com/docs/services/appoint/AppointGrounding.wsdl'
           ,6,1,getdate())
GO
----------------------------------Consult---------------------------------------------------------------------------------
INSERT INTO [SewDevel].[dbo].[Service]
           ([ServiceName]
           ,[Description]
           ,[FolderName]
           ,[ProviderId]
           ,[CreatedBy]
           ,[UpdatedBy]
           ,[Status]
           ,[CreatedOn]
           ,[UpdatedOn])
     VALUES
           ('Consult Service'
           ,'Consult Service Description'
           ,'http://test.biocomalert.com/docs/services/consult/'
           ,1
           ,1
           ,1
           ,1
           ,getdate()
           ,getdate())
GO

-- Service File
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (9
           ,'ConsultService.owl'
           ,'application/rdf+xml'
           ,'http://test.biocomalert.com/docs/services/consult/ConsultService.owl'
           ,'http://test.biocomalert.com/docs/services/consult/ConsultService.owl'
           ,1,1,getdate())
GO

-- Profile
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (9
           ,'ConsultProfile.owl'
           ,'application/rdf+xml'
           ,'http://test.biocomalert.com/docs/services/consult/ConsultProfile.owl'
           ,'http://test.biocomalert.com/docs/services/consult/ConsultProfile.owl'
           ,2,1,getdate())
GO

-- QoS Profile
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (9
           ,'ConsultQoSProfile.owl'
           ,'application/rdf+xml'
           ,'http://test.biocomalert.com/docs/services/consult/ConsultQoSProfile.owl'
           ,'http://test.biocomalert.com/docs/services/consult/ConsultQoSProfile.owl'
           ,3,1,getdate())
GO

-- Process
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (9
           ,'ConsultProcess.owl'
           ,'application/rdf+xml'
           ,'http://test.biocomalert.com/docs/services/consult/ConsultProcess.owl'
           ,'http://test.biocomalert.com/docs/services/consult/ConsultProcess.owl'
           ,4,1,getdate())
GO

-- Grounding
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (9
           ,'ConsultGrounding.owl'
           ,'application/rdf+xml'
           ,'http://test.biocomalert.com/docs/services/consult/ConsultGrounding.owl'
           ,'http://test.biocomalert.com/docs/services/consult/ConsultGrounding.owl'
           ,5,1,getdate())
GO

-- Wsdl Grounding
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (9
           ,'ConsultGrounding.wsdl'
           ,'application/wsdl+xml'
           ,'http://test.biocomalert.com/docs/services/consult/ConsultGrounding.wsdl'
           ,'http://test.biocomalert.com/docs/services/consult/ConsultGrounding.wsdl'
           ,6,1,getdate())
GO
-------------------------Explanation-------------------------------------------------------------------------------
INSERT INTO [SewDevel].[dbo].[Service]
           ([ServiceName]
           ,[Description]
           ,[FolderName]
           ,[ProviderId]
           ,[CreatedBy]
           ,[UpdatedBy]
           ,[Status]
           ,[CreatedOn]
           ,[UpdatedOn])
     VALUES
           ('Explanation Service'
           ,'Explanation Service Description'
           ,'http://test.biocomalert.com/docs/services/explain/'
           ,1
           ,1
           ,1
           ,1
           ,getdate()
           ,getdate())
GO

-- Service File
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (10
           ,'ExplainService.owl'
           ,'application/rdf+xml'
           ,'http://test.biocomalert.com/docs/services/explain/ExplainService.owl'
           ,'http://test.biocomalert.com/docs/services/explain/ExplainService.owl'
           ,1,1,getdate())
GO

-- Profile
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (10
           ,'ExplainProfile.owl'
           ,'application/rdf+xml'
           ,'http://test.biocomalert.com/docs/services/explain/ExplainProfile.owl'
           ,'http://test.biocomalert.com/docs/services/explain/ExplainProfile.owl'
           ,2,1,getdate())
GO

-- QoS Profile
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (10
           ,'ExplainQoSProfile.owl'
           ,'application/rdf+xml'
           ,'http://test.biocomalert.com/docs/services/explain/ExplainQoSProfile.owl'
           ,'http://test.biocomalert.com/docs/services/explain/ExplainQoSProfile.owl'
           ,3,1,getdate())
GO

-- Process
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (10
           ,'ExplainProcess.owl'
           ,'application/rdf+xml'
           ,'http://test.biocomalert.com/docs/services/explain/ExplainProcess.owl'
           ,'http://test.biocomalert.com/docs/services/explain/ExplainProcess.owl'
           ,4,1,getdate())
GO

-- Grounding
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (10
           ,'ExplainGrounding.owl'
           ,'application/rdf+xml'
           ,'http://test.biocomalert.com/docs/services/explain/ExplainGrounding.owl'
           ,'http://test.biocomalert.com/docs/services/explain/ExplainGrounding.owl'
           ,5,1,getdate())
GO

-- Wsdl Grounding
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (10
           ,'ExplainGrounding.wsdl'
           ,'application/wsdl+xml'
           ,'http://test.biocomalert.com/docs/services/explain/ExplainGrounding.wsdl'
           ,'http://test.biocomalert.com/docs/services/explain/ExplainGrounding.wsdl'
           ,6,1,getdate())
GO
------------------------Discover Caregiver----------------------------------------------------------------------------------
INSERT INTO [SewDevel].[dbo].[Service]
           ([ServiceName]
           ,[Description]
           ,[FolderName]
           ,[ProviderId]
           ,[CreatedBy]
           ,[UpdatedBy]
           ,[Status]
           ,[CreatedOn]
           ,[UpdatedOn])
     VALUES
           ('Discover Caregiver Service'
           ,'Discover Caregiver Service Description'
           ,'http://test.biocomalert.com/docs/services/caregiver/'
           ,1
           ,1
           ,1
           ,1
           ,getdate()
           ,getdate())
GO

-- Service File
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (11
           ,'CareGiverService.owl'
           ,'application/rdf+xml'
           ,'http://test.biocomalert.com/docs/services/caregiver/CareGiverService.owl'
           ,'http://test.biocomalert.com/docs/services/caregiver/CareGiverService.owl'
           ,1,1,getdate())
GO

-- Profile
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (11
           ,'CareGiverProfile.owl'
           ,'application/rdf+xml'
           ,'http://test.biocomalert.com/docs/services/caregiver/CareGiverProfile.owl'
           ,'http://test.biocomalert.com/docs/services/caregiver/CareGiverProfile.owl'
           ,2,1,getdate())
GO

-- QoS Profile
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (11
           ,'CareGiverQoSProfile.owl'
           ,'application/rdf+xml'
           ,'http://test.biocomalert.com/docs/services/caregiver/CareGiverQoSProfile.owl'
           ,'http://test.biocomalert.com/docs/services/caregiver/CareGiverQoSProfile.owl'
           ,3,1,getdate())
GO

-- Process
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (11
           ,'CareGiverProcess.owl'
           ,'application/rdf+xml'
           ,'http://test.biocomalert.com/docs/services/caregiver/CareGiverProcess.owl'
           ,'http://test.biocomalert.com/docs/services/caregiver/CareGiverProcess.owl'
           ,4,1,getdate())
GO

-- Grounding
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (11
           ,'CareGiverGrounding.owl'
           ,'application/rdf+xml'
           ,'http://test.biocomalert.com/docs/services/caregiver/CareGiverGrounding.owl'
           ,'http://test.biocomalert.com/docs/services/caregiver/CareGiverGrounding.owl'
           ,5,1,getdate())
GO

-- Wsdl Grounding
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (11
           ,'CareGiverGrounding.wsdl'
           ,'application/wsdl+xml'
           ,'http://test.biocomalert.com/docs/services/caregiver/CareGiverGrounding.wsdl'
           ,'http://test.biocomalert.com/docs/services/caregiver/CareGiverGrounding.wsdl'
           ,6,1,getdate())
GO
-----------------------------Deliver Care----------------------------------------------------------------
INSERT INTO [SewDevel].[dbo].[Service]
           ([ServiceName]
           ,[Description]
           ,[FolderName]
           ,[ProviderId]
           ,[CreatedBy]
           ,[UpdatedBy]
           ,[Status]
           ,[CreatedOn]
           ,[UpdatedOn])
     VALUES
           ('Delliver Care Service'
           ,'Deliver Care Service Description'
           ,'http://test.biocomalert.com/docs/services/delivercare/'
           ,1
           ,1
           ,1
           ,1
           ,getdate()
           ,getdate())
GO

-- Service File
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (12
           ,'DeliverCareService.owl'
           ,'application/rdf+xml'
           ,'http://test.biocomalert.com/docs/services/delivercare/DeliverCareService.owl'
           ,'http://test.biocomalert.com/docs/services/delivercare/DeliverCareService.owl'
           ,1,1,getdate())
GO

-- Profile
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (12
           ,'DeliverCareProfile.owl'
           ,'application/rdf+xml'
           ,'http://test.biocomalert.com/docs/services/delivercare/DeliverCareProfile.owl'
           ,'http://test.biocomalert.com/docs/services/delivercare/DeliverCareProfile.owl'
           ,2,1,getdate())
GO

-- QoS Profile
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (12
           ,'DeliverCareQoSProfile.owl'
           ,'application/rdf+xml'
           ,'http://test.biocomalert.com/docs/services/delivercare/DeliverCareQoSProfile.owl'
           ,'http://test.biocomalert.com/docs/services/delivercare/DeliverCareQoSProfile.owl'
           ,3,1,getdate())
GO

-- Process
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (12
           ,'DeliverCareProcess.owl'
           ,'application/rdf+xml'
           ,'http://test.biocomalert.com/docs/services/delivercare/DeliverCareProcess.owl'
           ,'http://test.biocomalert.com/docs/services/delivercare/DeliverCareProcess.owl'
           ,4,1,getdate())
GO

-- Grounding
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (12
           ,'DeliverCareGrounding.owl'
           ,'application/rdf+xml'
           ,'http://test.biocomalert.com/docs/services/delivercare/DeliverCareGrounding.owl'
           ,'http://test.biocomalert.com/docs/services/delivercare/DeliverCareGrounding.owl'
           ,5,1,getdate())
GO

-- Wsdl Grounding
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (12
           ,'DeliverCareGrounding.wsdl'
           ,'application/wsdl+xml'
           ,'http://test.biocomalert.com/docs/services/delivercare/DeliverCareGrounding.wsdl'
           ,'http://test.biocomalert.com/docs/services/delivercare/DeliverCareGrounding.wsdl'
           ,6,1,getdate())
GO
------------Prescribe Drug Service----------------------------------------------------------------------------------------------------
INSERT INTO [SewDevel].[dbo].[Service]
           ([ServiceName]
           ,[Description]
           ,[FolderName]
           ,[ProviderId]
           ,[CreatedBy]
           ,[UpdatedBy]
           ,[Status]
           ,[CreatedOn]
           ,[UpdatedOn])
     VALUES
           ('Prescribe Drug Service'
           ,'Prescribe Drug Service Description'
           ,'http://test.biocomalert.com/docs/services/drug/'
           ,1
           ,1
           ,1
           ,1
           ,getdate()
           ,getdate())
GO

-- Service File
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (13
           ,'PrescribeDrugService.owl'
           ,'application/rdf+xml'
           ,'http://test.biocomalert.com/docs/services/drug/PrescribeDrugService.owl'
           ,'http://test.biocomalert.com/docs/services/drug/PrescribeDrugService.owl'
           ,1,1,getdate())
GO

-- Profile
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (13
           ,'PrescribeDrugProfile.owl'
           ,'application/rdf+xml'
           ,'http://test.biocomalert.com/docs/services/drug/PrescribeDrugProfile.owl'
           ,'http://test.biocomalert.com/docs/services/drug/PrescribeDrugProfile.owl'
           ,2,1,getdate())
GO

-- QoS Profile
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (13
           ,'PrescribeDrugQoSProfile.owl'
           ,'application/rdf+xml'
           ,'http://test.biocomalert.com/docs/services/drug/PrescribeDrugQoSProfile.owl'
           ,'http://test.biocomalert.com/docs/services/drug/PrescribeDrugQoSProfile.owl'
           ,3,1,getdate())
GO

-- Process
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (13
           ,'PrescribeDrugProcess.owl'
           ,'application/rdf+xml'
           ,'http://test.biocomalert.com/docs/services/drug/PrescribeDrugProcess.owl'
           ,'http://test.biocomalert.com/docs/services/drug/PrescribeDrugProcess.owl'
           ,4,1,getdate())
GO

-- Grounding
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (13
           ,'PrescribeDrugGrounding.owl'
           ,'application/rdf+xml'
           ,'http://test.biocomalert.com/docs/services/drug/PrescribeDrugGrounding.owl'
           ,'http://test.biocomalert.com/docs/services/drug/PrescribeDrugGrounding.owl'
           ,5,1,getdate())
GO

-- Wsdl Grounding
INSERT INTO [SewDevel].[dbo].[ServiceDetails]
           ([ServiceId]
           ,[ServiceFileName]
           ,[MimeType]
           ,[WebURL]
           ,[UploadedPath]
           ,[ServiceFileTypeId]
           ,[Status]
           ,[CreatedOn])
     VALUES
           (13
           ,'PrescribeDrugGrounding.wsdl'
           ,'application/wsdl+xml'
           ,'http://test.biocomalert.com/docs/services/drug/PrescribeDrugGrounding.wsdl'
           ,'http://test.biocomalert.com/docs/services/drug/PrescribeDrugGrounding.wsdl'
           ,6,1,getdate())
GO