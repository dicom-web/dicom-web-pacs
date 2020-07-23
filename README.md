# dicom-web-pacs

#### Introduction
web medical image archiving and reading system

#### Software Architecture
SpringBoot as the infrastructure

MySql as a database

Storage using MINIO/OSS

Implementation of Dicom protocol using DCM4CHEE

At present, Dicom's receiving and storage has been realized. Next, DICOM will be parsed and archived. Some problems may be encountered in this part. Finally, a new project will be built to realize Dicom's Web reading function.


#### Installation tutorial
Each module can be started directly using java -jar

#### Instructions for use

1. web-pacs-scp is used to receive Dicom images transmitted by CT equipment

2. web-pacs-view is used to display DICOM images on the web


#### contact me
If you have any questions, feel free to email me
lainiao@live.cn