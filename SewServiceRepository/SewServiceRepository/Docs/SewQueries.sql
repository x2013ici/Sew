use [SewDevel]
GO

select * from Country
select * from Address

select * from ProviderSignupRequest
select * from ProviderSignupRequester
select * from Provider

select * from UserType
select * from [User]
select * from UserLoginSession


Select * from [Service] where 
Select * from ServiceDetails

update [Service] set ProviderId=1 where Id  in (1,3,5,7,9,11,13)

update [Service] set ServiceName='Consult Service', Description='Consult Service Description',FolderName='http://test.biocomalert.com/docs/services/consult/' where Id=9
update [Service] set ServiceName='Explanation Service', Description='Explanation Service Description',FolderName='http://test.biocomalert.com/docs/services/explain/' where Id=10

truncate table [Service]
truncate table ServiceDetails
-----------------------------------------------------------------------------------------------

select * from [User]
select * from UserLoginSession

-- Id,Address,Street,CountryId,City,State,Zipcode,Status,CreatedOn,UpdatedOn
sp_help Address
select * from Address

sp_help Country
select * from Country
-- Id,Name,Code,Status,CreatedOn,UpdatedOn

sp_help Provider
-- Id,Name,Phone,Email,Fax,AddressId,Status,CreatedOn,CreatedBy,UpdatedOn,UpdatedBy
select * from Provider

sp_help ProviderSignupRequest
-- Id,Name,Phone,Email,Fax,AddressId,Status,RequestedOn,UpdatedOn

select * from ProviderSignupRequest
select * from ProviderSignupRequester

sp_help ProviderSignupRequester -- Id,FirstName,LastName,UserName,Password,Phone,Email,DOB,Gender,AddressId,Status,CreatedOn,UpdatedOn

Select * from [Service]
sp_help [Service] -- Id,ServiceName,Description,FolderName,ProviderId,Status,UploadedOn,UploadedBy,UpdatedOn,UpdatedBy

Select * from ServiceDetails

sp_help ServiceDetails -- Id,ServiceId,ServiceFileName,MimeType,WebURL,UploadedPath,ServiceFileTypeId,Status,CreatedOn,UpdatedOn

select * from [User]
sp_help [User] -- Id,FirstName,LastName,UserName,Email,Password,DOB,ContactNumber,UploadPath,ProfilePicture,ProfilePictureThumbnail,Gender,UserTypeId,CompanyId,AddressId,Status,CreatedOn,CreatedBy,UpdatedOn,UpdatedBy

select * from UserLoginSession

sp_help UserLoginSession -- Id,UserId,SessionToken,DeviceMacId,Status,CreatedOn,UpdatedOn

sp_help UserSignupRequest -- Id,FirstName,LastName,UserName,Password,EmailAddress,DOB,Phone,ActivationCode,Gender,Status,CreatedOn,CreatedBy,UpdatedOn,UpdatedBy

select * from UserSignupRequest -- do use this table for now
sp_help UserSignupRequest -- Id,FirstName,LastName,UserName,Password,EmailAddress,DOB,Phone,ActivationCode,Gender,Status,CreatedOn,CreatedB,UpdatedOn,UpdatedBy

select * from UserType

sp_help UserType -- Id,Name,Description,Status,CreatedOn,UpdatedOn

Select * from ServiceDetails where ServiceId=2
delete from ServiceDetails where ServiceId=2

use [Employee]
GO

select * from Department
select * from Employee
select * from Enrollment


