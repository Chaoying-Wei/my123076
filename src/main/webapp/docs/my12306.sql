prompt PL/SQL Developer import file
prompt Created on 2019��10��8�� by admin
set feedback off
set define off
prompt Disabling triggers for REUSER...
alter table REUSER disable all triggers;
prompt Disabling triggers for TICKET...
alter table TICKET disable all triggers;
prompt Disabling foreign key constraints for TICKET...
alter table TICKET disable constraint FK_TICKET_USERNAME;
prompt Deleting TICKET...
delete from TICKET;
commit;
prompt Deleting REUSER...
delete from REUSER;
commit;
prompt Loading REUSER...
insert into REUSER (renames, repass, retruename, sex, province, city, cardtpye, idnumber, passengertype, tips, borthday)
values ('Τ��', '123', 'Τ��Ӣ', 'Ů', '����׳��', '�ӳ���', '1 ', '4523456565656', '����', '����i������������', to_date('02-02-1999', 'dd-mm-yyyy'));
insert into REUSER (renames, repass, retruename, sex, province, city, cardtpye, idnumber, passengertype, tips, borthday)
values ('aaa', '123', 'aab', 'Ů', '����׳��', '�ӳ���', '1 ', '4523456565656', '����', '����i������������', to_date('02-02-1999', 'dd-mm-yyyy'));
insert into REUSER (renames, repass, retruename, sex, province, city, cardtpye, idnumber, passengertype, tips, borthday)
values ('aaaa', '123', 'ss', null, null, null, null, null, null, null, null);
insert into REUSER (renames, repass, retruename, sex, province, city, cardtpye, idnumber, passengertype, tips, borthday)
values ('h', '12', 'hhhh', '��', 'ʡ��', '����', '1 ', '45456435345', '����', 'sdfdsf��������', to_date('02-02-1999', 'dd-mm-yyyy'));
insert into REUSER (renames, repass, retruename, sex, province, city, cardtpye, idnumber, passengertype, tips, borthday)
values ('weichaoying', '123456', 'wcy', 'Ů', '����׳��', '�ӳ���', '1 ', '4523456565656', '����', '����i������������', to_date('05-02-1999', 'dd-mm-yyyy'));
insert into REUSER (renames, repass, retruename, sex, province, city, cardtpye, idnumber, passengertype, tips, borthday)
values ('weicy', '123', 'weichaoying', '��', 'ʡ��', '����', '1 ', '4523456565656', '����', 'hahhahahahahahahahha', to_date('02-02-1999', 'dd-mm-yyyy'));
insert into REUSER (renames, repass, retruename, sex, province, city, cardtpye, idnumber, passengertype, tips, borthday)
values ('haha', '123', '����', '��', '����׳��', '�ӳ���', '1 ', '4523456565656', '����', '����i������������', to_date('02-02-1999', 'dd-mm-yyyy'));
insert into REUSER (renames, repass, retruename, sex, province, city, cardtpye, idnumber, passengertype, tips, borthday)
values ('user', '123', 'trueuser', 'Ů', '����׳��', '�ӳ���', '1 ', '4523456565656', '����', null, null);
commit;
prompt 8 records loaded
prompt Loading TICKET...
insert into TICKET (ticketid, startstation, endstation, startdate, starttime, renames)
values (201949, '����', '����', to_date('15-10-2019', 'dd-mm-yyyy'), to_date('15-10-2019 14:04:34', 'dd-mm-yyyy hh24:mi:ss'), 'Τ��');
insert into TICKET (ticketid, startstation, endstation, startdate, starttime, renames)
values (201923, '������', '����', to_date('17-10-2019', 'dd-mm-yyyy'), to_date('17-10-2019 12:20:30', 'dd-mm-yyyy hh24:mi:ss'), 'h');
insert into TICKET (ticketid, startstation, endstation, startdate, starttime, renames)
values (201944, '����', '������', to_date('08-10-2019', 'dd-mm-yyyy'), to_date('08-10-2019 13:55:22', 'dd-mm-yyyy hh24:mi:ss'), 'haha');
insert into TICKET (ticketid, startstation, endstation, startdate, starttime, renames)
values (201947, '����', '������', to_date('09-10-2019', 'dd-mm-yyyy'), to_date('09-10-2019 14:02:58', 'dd-mm-yyyy hh24:mi:ss'), 'weicy');
insert into TICKET (ticketid, startstation, endstation, startdate, starttime, renames)
values (201948, '����', '������', to_date('27-10-2019', 'dd-mm-yyyy'), to_date('27-10-2019 14:04:07', 'dd-mm-yyyy hh24:mi:ss'), 'weichaoying');
insert into TICKET (ticketid, startstation, endstation, startdate, starttime, renames)
values (201941, '������', '����', to_date('08-10-2019', 'dd-mm-yyyy'), to_date('08-10-2019 10:53:14', 'dd-mm-yyyy hh24:mi:ss'), 'Τ��');
commit;
prompt 6 records loaded
prompt Enabling foreign key constraints for TICKET...
alter table TICKET enable constraint FK_TICKET_USERNAME;
prompt Enabling triggers for REUSER...
alter table REUSER enable all triggers;
prompt Enabling triggers for TICKET...
alter table TICKET enable all triggers;
set feedback on
set define on
prompt Done.
