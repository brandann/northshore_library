Imports System.IO

Public Class Form1

    Dim Details() As String

    Private Sub Form1_Load(sender As System.Object, e As System.EventArgs) Handles MyBase.Load
        comboTags.SelectedIndex = 0 'set the index to 0 (all)
        getDetails() 'load the database into an array
        lookup("2")
    End Sub

    Private Sub comboTags_SelectedIndexChanged(sender As System.Object, e As System.EventArgs) Handles comboTags.SelectedIndexChanged
        Dim filename As String = ""
        If comboTags.SelectedIndex = 0 Then
            setList("CompiledTags.txt")
            Return
        Else
            setList(comboTags.SelectedItem.ToString + ".txt")
        End If
    End Sub

    Private Sub setList(ByRef file)
        listTagLibrary.Items.Clear() 'clear out the listbox
        Dim path As String = "P:\Northshore Time Sheet\Tools\LIBRARY\" & file 'set the path to the ref file
        Using sr As New StreamReader(path) 'read file and set listbox
            Dim line As String
            Do While sr.Peek <> -1
                listTagLibrary.Items.Add(sr.ReadLine())
            Loop
        End Using
    End Sub

    Private Sub listTagLibrary_MouseDoubleClick(sender As System.Object, e As System.Windows.Forms.MouseEventArgs) Handles listTagLibrary.MouseDoubleClick
        listTags.Items.Add(listTagLibrary.SelectedItem)
        listTags.Sorted = True
    End Sub

    Private Sub Button5_Click(sender As System.Object, e As System.EventArgs) Handles Button5.Click
        If (listTags.SelectedIndex > -1) Then
            listTags.Items.RemoveAt(listTags.SelectedIndex)
        End If
    End Sub

    Private Sub Button4_Click(sender As System.Object, e As System.EventArgs) Handles Button4.Click
        listTags.Items.Clear()
    End Sub

    Private Sub Button6_Click(sender As System.Object, e As System.EventArgs) Handles Button6.Click
        listTags.Items.Add(txtNotes.Text)
    End Sub

    Private Sub textNotes_KeyDown(sender As System.Object, e As System.Windows.Forms.KeyEventArgs) Handles txtNotes.KeyDown
        If e.KeyCode = Keys.Enter Then
            listTags.Items.Add(txtNotes.Text)
        End If
    End Sub

    Private Sub getDetails()
        Dim count As Integer
        Using sr As New StreamReader("P:\Northshore Time Sheet\Tools\LIBRARY\database.dat")
            Do While sr.Peek <> -1
                sr.ReadLine()
                count += 1
            Loop
        End Using
        Dim D(count - 1) As String
        count = 0
        Using sr As New StreamReader("P:\Northshore Time Sheet\Tools\LIBRARY\database.dat")
            Do While sr.Peek <> -1
                D(count) = sr.ReadLine()
                count += 1
            Loop
        End Using
        D(0) = ""
        D(1) = ""
        Details = D
    End Sub

    Private Sub textLookup_KeyDown(sender As System.Object, e As System.Windows.Forms.KeyEventArgs) Handles textLookup.KeyDown
        If e.KeyCode = Keys.Enter Then
            lookup(textLookup.Text)
        End If
    End Sub

    Private Sub lookup(ByRef i)
        Dim s() As String
        For Each value As String In Details
            s = value.Split("$")
            If s(0) = i Then
                getDetail(value)
                Return
            End If
        Next
        textLookup.Text = txtEntry.Text
    End Sub

    Private Sub getDetail(ByRef detail)
        clearForm()
        Dim detailParts() As String
        detailParts = detail.split("$")
        txtEntry.Text = detailParts(0)
        cboCompany.SelectedIndex = cboCompany.Items.IndexOf(detailParts(1))
        txtJob.Text = detailParts(2)
        txtNumber.Text = detailParts(3)
        txtdate.Text = detailParts(5)
        txtDescription.Text = detailParts(6)
        txtPDF.Text = detailParts(7)
        txtDWG.Text = detailParts(8)
        txtImage.Text = detailParts(9)
        Dim tags() As String
        tags = detailParts(10).Split(">>")
        For Each value As String In tags
            If value <> "" Then
                listTags.Items.Add(value)
            End If
        Next
        Dim loc As String = "P:\Northshore Time Sheet\Tools\LIBRARY\" & txtImage.Text
        DetailImage.ImageLocation = loc
        DetailImage.SizeMode = PictureBoxSizeMode.Zoom
        textLookup.Text = txtEntry.Text
    End Sub

    Private Sub clearForm()
        txtEntry.Text = ""
        cboCompany.SelectedIndex = 0
        txtJob.Text = ""
        txtNumber.Text = ""
        txtdate.Text = ""
        txtDescription.Text = ""
        txtPDF.Text = ""
        txtDWG.Text = ""
        txtImage.Text = ""
        DetailImage.ImageLocation = "P:\Northshore Time Sheet\Tools\LIBRARY\blank.png"
        listTags.Items.Clear()
    End Sub

    Private Sub setDetail()
        Dim detail, entry, company, name, number, blank, ddate, descrpition, img, pdf, dwg, tags As String
        entry = txtEntry.Text & "$"
        company = cboCompany.SelectedItem & "$"
        name = txtJob.Text & "$"
        number = txtNumber.Text & "$"
        blank = "" & "$"
        ddate = txtdate.Text & "$"
        descrpition = txtDescription.Text & "$"
        img = txtImage.Text & "$"
        pdf = txtPDF.Text & "$"
        dwg = txtDWG.Text & "$"
        tags = ""
        For index As Integer = 0 To listTags.Items.Count - 1
            tags = tags & listTags.Items.Item(index) & ">>"
        Next
        detail = entry & company & name & number & blank & ddate & descrpition & pdf & dwg & img & tags
        Details(Integer.Parse(textLookup.Text)) = detail
    End Sub


    Private Sub buttonLast_Click(sender As System.Object, e As System.EventArgs) Handles buttonLast.Click
        save()
        Dim lastentry As String = Details(Details.Length - 1)
        Dim entry() As String = lastentry.Split("$")
        lookup(entry(0))
    End Sub

    Private Sub buttonNext_Click(sender As System.Object, e As System.EventArgs) Handles buttonNext.Click
        save()
        lookup((Integer.Parse(textLookup.Text) + 1).ToString)
    End Sub

    Private Sub buttonPrev_Click(sender As System.Object, e As System.EventArgs) Handles buttonPrev.Click
        save()
        lookup((Integer.Parse(textLookup.Text) - 1).ToString)
    End Sub

    Private Sub buttonFirst_Click(sender As System.Object, e As System.EventArgs) Handles buttonFirst.Click
        save()
        lookup("2")
    End Sub

    Private Sub saveDetail()
        Dim lastentry As String = Details(Details.Length - 1)
        Dim entry() As String = lastentry.Split("$")
        Dim lastnum As String = entry(0)
        Dim file As System.IO.StreamWriter
        file = My.Computer.FileSystem.OpenTextFileWriter("P:\Northshore Time Sheet\Tools\LIBRARY\database.dat", False)
        file.WriteLine("1234567890")
        file.WriteLine(lastnum)
        For Each value As String In Details
            If value <> "" Then
                file.WriteLine(value)
            End If
        Next
        file.Close()
    End Sub

    Private Sub Button7_Click_1(sender As System.Object, e As System.EventArgs) Handles Button7.Click
        save()
    End Sub

    Private Sub save()
        setDetail()
        saveDetail()
    End Sub

    Private Sub Button8_Click(sender As System.Object, e As System.EventArgs) Handles Button8.Click
        Me.Close()
    End Sub

    Private Sub Form1_FormClosing(sender As System.Object, e As System.Windows.Forms.FormClosingEventArgs) Handles MyBase.FormClosing
        'save()
    End Sub

    Private Sub Form1_FormClosed(sender As System.Object, e As System.Windows.Forms.FormClosedEventArgs) Handles MyBase.FormClosed
        save()
        Return
        Dim result As Integer = MessageBox.Show("Do you want to save before closing?", "save", MessageBoxButtons.YesNo)
        If result = DialogResult.No Then
            'go back to form
        ElseIf result = DialogResult.Yes Then
            save()
        End If
    End Sub

    Private Sub txtNotes_MouseDoubleClick(sender As System.Object, e As System.Windows.Forms.MouseEventArgs) Handles txtNotes.MouseDoubleClick
        listTags.Items.RemoveAt(listTags.SelectedIndex)
    End Sub
End Class
