<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class Form1
    Inherits System.Windows.Forms.Form

    'Form overrides dispose to clean up the component list.
    <System.Diagnostics.DebuggerNonUserCode()> _
    Protected Overrides Sub Dispose(ByVal disposing As Boolean)
        Try
            If disposing AndAlso components IsNot Nothing Then
                components.Dispose()
            End If
        Finally
            MyBase.Dispose(disposing)
        End Try
    End Sub

    'Required by the Windows Form Designer
    Private components As System.ComponentModel.IContainer

    'NOTE: The following procedure is required by the Windows Form Designer
    'It can be modified using the Windows Form Designer.  
    'Do not modify it using the code editor.
    <System.Diagnostics.DebuggerStepThrough()> _
    Private Sub InitializeComponent()
        Me.components = New System.ComponentModel.Container()
        Dim resources As System.ComponentModel.ComponentResourceManager = New System.ComponentModel.ComponentResourceManager(GetType(Form1))
        Me.TextSearchBox = New System.Windows.Forms.TextBox()
        Me.Label1 = New System.Windows.Forms.Label()
        Me.Label2 = New System.Windows.Forms.Label()
        Me.TextSearchButton = New System.Windows.Forms.Button()
        Me.GlobalExitButton = New System.Windows.Forms.Button()
        Me.Panel1 = New System.Windows.Forms.Panel()
        Me.AdvancedExcludeButton = New System.Windows.Forms.Button()
        Me.AdvancedIncludeRemoveButton = New System.Windows.Forms.Button()
        Me.AdvancedExcludeList = New System.Windows.Forms.ListBox()
        Me.AdvancedIncludeList = New System.Windows.Forms.ListBox()
        Me.Label6 = New System.Windows.Forms.Label()
        Me.Label5 = New System.Windows.Forms.Label()
        Me.TextSearchClear = New System.Windows.Forms.Button()
        Me.GlobalDatabaseSizeLabel = New System.Windows.Forms.Label()
        Me.TextSearchHelpLabel = New System.Windows.Forms.LinkLabel()
        Me.AdvancedTagList = New System.Windows.Forms.ListBox()
        Me.ToolTip1 = New System.Windows.Forms.ToolTip(Me.components)
        Me.Label4 = New System.Windows.Forms.Label()
        Me.AdvancedTagCatCombo = New System.Windows.Forms.ComboBox()
        Me.TabControl1 = New System.Windows.Forms.TabControl()
        Me.TabPage1 = New System.Windows.Forms.TabPage()
        Me.TextSearchResults = New System.Windows.Forms.ListBox()
        Me.TabPage2 = New System.Windows.Forms.TabPage()
        Me.Label10 = New System.Windows.Forms.Label()
        Me.AdvancedTagAddButton = New System.Windows.Forms.Button()
        Me.TabPage3 = New System.Windows.Forms.TabPage()
        Me.JobNumberOpenButton = New System.Windows.Forms.Button()
        Me.JobNumberList = New System.Windows.Forms.ListBox()
        Me.TabPage4 = New System.Windows.Forms.TabPage()
        Me.JobNameOpenButton = New System.Windows.Forms.Button()
        Me.JobNameList = New System.Windows.Forms.ListBox()
        Me.TabPage5 = New System.Windows.Forms.TabPage()
        Me.Label7 = New System.Windows.Forms.Label()
        Me.Label3 = New System.Windows.Forms.Label()
        Me.NorthshoreStandardSystemOpenButton = New System.Windows.Forms.Button()
        Me.NorthshoreStandardDetailOpenButton = New System.Windows.Forms.Button()
        Me.NorthshoreStandardDetailList = New System.Windows.Forms.ListBox()
        Me.NorthshoreStandardSystemList = New System.Windows.Forms.ListBox()
        Me.TabPage6 = New System.Windows.Forms.TabPage()
        Me.Label8 = New System.Windows.Forms.Label()
        Me.Label9 = New System.Windows.Forms.Label()
        Me.NorthcladStandardSystemOpenButton = New System.Windows.Forms.Button()
        Me.NorthcladStandardDetailOpenList = New System.Windows.Forms.Button()
        Me.NorthcladStandardDetailList = New System.Windows.Forms.ListBox()
        Me.NorthcladStandardSystemList = New System.Windows.Forms.ListBox()
        Me.AdvancedClearButton = New System.Windows.Forms.Button()
        Me.AdvancedSearchButton = New System.Windows.Forms.Button()
        Me.Label11 = New System.Windows.Forms.Label()
        Me.Label12 = New System.Windows.Forms.Label()
        Me.Label13 = New System.Windows.Forms.Label()
        Me.Label14 = New System.Windows.Forms.Label()
        Me.Label15 = New System.Windows.Forms.Label()
        Me.Panel1.SuspendLayout()
        Me.TabControl1.SuspendLayout()
        Me.TabPage1.SuspendLayout()
        Me.TabPage2.SuspendLayout()
        Me.TabPage3.SuspendLayout()
        Me.TabPage4.SuspendLayout()
        Me.TabPage5.SuspendLayout()
        Me.TabPage6.SuspendLayout()
        Me.SuspendLayout()
        '
        'TextSearchBox
        '
        Me.TextSearchBox.BackColor = System.Drawing.SystemColors.Window
        Me.TextSearchBox.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle
        Me.TextSearchBox.Font = New System.Drawing.Font("Arial Narrow", 11.25!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.TextSearchBox.ForeColor = System.Drawing.Color.MidnightBlue
        Me.TextSearchBox.Location = New System.Drawing.Point(37, 156)
        Me.TextSearchBox.Multiline = True
        Me.TextSearchBox.Name = "TextSearchBox"
        Me.TextSearchBox.Size = New System.Drawing.Size(667, 60)
        Me.TextSearchBox.TabIndex = 100
        '
        'Label1
        '
        Me.Label1.AutoSize = True
        Me.Label1.Font = New System.Drawing.Font("Arial", 9.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Label1.Location = New System.Drawing.Point(34, 123)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(212, 30)
        Me.Label1.TabIndex = 1
        Me.Label1.Text = "Seperate search items with a comma" & Global.Microsoft.VisualBasic.ChrW(13) & Global.Microsoft.VisualBasic.ChrW(10) & "search is NOT case sensitive"
        '
        'Label2
        '
        Me.Label2.AutoSize = True
        Me.Label2.Font = New System.Drawing.Font("Watford", 25.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Label2.Location = New System.Drawing.Point(137, 9)
        Me.Label2.Name = "Label2"
        Me.Label2.Size = New System.Drawing.Size(488, 42)
        Me.Label2.TabIndex = 2
        Me.Label2.Text = "Northshore Library Database"
        '
        'TextSearchButton
        '
        Me.TextSearchButton.Font = New System.Drawing.Font("Microsoft Sans Serif", 10.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.TextSearchButton.Location = New System.Drawing.Point(592, 429)
        Me.TextSearchButton.Name = "TextSearchButton"
        Me.TextSearchButton.Size = New System.Drawing.Size(141, 28)
        Me.TextSearchButton.TabIndex = 3
        Me.TextSearchButton.Text = "Search"
        Me.TextSearchButton.UseVisualStyleBackColor = True
        '
        'GlobalExitButton
        '
        Me.GlobalExitButton.Font = New System.Drawing.Font("Microsoft Sans Serif", 10.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.GlobalExitButton.Location = New System.Drawing.Point(5, 572)
        Me.GlobalExitButton.Name = "GlobalExitButton"
        Me.GlobalExitButton.Size = New System.Drawing.Size(141, 28)
        Me.GlobalExitButton.TabIndex = 4
        Me.GlobalExitButton.Text = "Exit"
        Me.GlobalExitButton.UseVisualStyleBackColor = True
        '
        'Panel1
        '
        Me.Panel1.Controls.Add(Me.Label15)
        Me.Panel1.Controls.Add(Me.AdvancedExcludeButton)
        Me.Panel1.Controls.Add(Me.AdvancedIncludeRemoveButton)
        Me.Panel1.Controls.Add(Me.AdvancedExcludeList)
        Me.Panel1.Controls.Add(Me.AdvancedIncludeList)
        Me.Panel1.Controls.Add(Me.Label6)
        Me.Panel1.Controls.Add(Me.Label5)
        Me.Panel1.Location = New System.Drawing.Point(7, 30)
        Me.Panel1.Name = "Panel1"
        Me.Panel1.Size = New System.Drawing.Size(393, 392)
        Me.Panel1.TabIndex = 5
        '
        'AdvancedExcludeButton
        '
        Me.AdvancedExcludeButton.Enabled = False
        Me.AdvancedExcludeButton.Location = New System.Drawing.Point(315, 339)
        Me.AdvancedExcludeButton.Name = "AdvancedExcludeButton"
        Me.AdvancedExcludeButton.Size = New System.Drawing.Size(75, 23)
        Me.AdvancedExcludeButton.TabIndex = 110
        Me.AdvancedExcludeButton.Text = "Remove"
        Me.AdvancedExcludeButton.UseVisualStyleBackColor = True
        '
        'AdvancedIncludeRemoveButton
        '
        Me.AdvancedIncludeRemoveButton.Location = New System.Drawing.Point(315, 163)
        Me.AdvancedIncludeRemoveButton.Name = "AdvancedIncludeRemoveButton"
        Me.AdvancedIncludeRemoveButton.Size = New System.Drawing.Size(75, 23)
        Me.AdvancedIncludeRemoveButton.TabIndex = 11
        Me.AdvancedIncludeRemoveButton.Text = "Remove"
        Me.AdvancedIncludeRemoveButton.UseVisualStyleBackColor = True
        '
        'AdvancedExcludeList
        '
        Me.AdvancedExcludeList.BackColor = System.Drawing.SystemColors.Window
        Me.AdvancedExcludeList.BorderStyle = System.Windows.Forms.BorderStyle.None
        Me.AdvancedExcludeList.Enabled = False
        Me.AdvancedExcludeList.Font = New System.Drawing.Font("Arial", 8.25!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.AdvancedExcludeList.FormattingEnabled = True
        Me.AdvancedExcludeList.ItemHeight = 14
        Me.AdvancedExcludeList.Location = New System.Drawing.Point(6, 221)
        Me.AdvancedExcludeList.Name = "AdvancedExcludeList"
        Me.AdvancedExcludeList.Size = New System.Drawing.Size(384, 112)
        Me.AdvancedExcludeList.TabIndex = 109
        '
        'AdvancedIncludeList
        '
        Me.AdvancedIncludeList.BackColor = System.Drawing.SystemColors.Window
        Me.AdvancedIncludeList.BorderStyle = System.Windows.Forms.BorderStyle.None
        Me.AdvancedIncludeList.Font = New System.Drawing.Font("Arial", 8.25!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.AdvancedIncludeList.FormattingEnabled = True
        Me.AdvancedIncludeList.ItemHeight = 14
        Me.AdvancedIncludeList.Location = New System.Drawing.Point(6, 45)
        Me.AdvancedIncludeList.Name = "AdvancedIncludeList"
        Me.AdvancedIncludeList.Size = New System.Drawing.Size(384, 112)
        Me.AdvancedIncludeList.TabIndex = 11
        '
        'Label6
        '
        Me.Label6.AutoSize = True
        Me.Label6.Font = New System.Drawing.Font("Microsoft Sans Serif", 8.25!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Label6.Location = New System.Drawing.Point(6, 205)
        Me.Label6.Name = "Label6"
        Me.Label6.Size = New System.Drawing.Size(114, 13)
        Me.Label6.TabIndex = 108
        Me.Label6.Text = "Exclude Keywords:"
        '
        'Label5
        '
        Me.Label5.AutoSize = True
        Me.Label5.Font = New System.Drawing.Font("Microsoft Sans Serif", 8.25!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Label5.Location = New System.Drawing.Point(3, 30)
        Me.Label5.Name = "Label5"
        Me.Label5.Size = New System.Drawing.Size(111, 13)
        Me.Label5.TabIndex = 106
        Me.Label5.Text = "Include Keywords:"
        '
        'TextSearchClear
        '
        Me.TextSearchClear.Font = New System.Drawing.Font("Microsoft Sans Serif", 10.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.TextSearchClear.Location = New System.Drawing.Point(445, 429)
        Me.TextSearchClear.Name = "TextSearchClear"
        Me.TextSearchClear.Size = New System.Drawing.Size(141, 28)
        Me.TextSearchClear.TabIndex = 10
        Me.TextSearchClear.Text = "Clear"
        Me.TextSearchClear.UseVisualStyleBackColor = True
        '
        'GlobalDatabaseSizeLabel
        '
        Me.GlobalDatabaseSizeLabel.AutoSize = True
        Me.GlobalDatabaseSizeLabel.Location = New System.Drawing.Point(141, 51)
        Me.GlobalDatabaseSizeLabel.Name = "GlobalDatabaseSizeLabel"
        Me.GlobalDatabaseSizeLabel.Size = New System.Drawing.Size(40, 13)
        Me.GlobalDatabaseSizeLabel.TabIndex = 101
        Me.GlobalDatabaseSizeLabel.Text = "Length"
        '
        'TextSearchHelpLabel
        '
        Me.TextSearchHelpLabel.AutoSize = True
        Me.TextSearchHelpLabel.BackColor = System.Drawing.SystemColors.Control
        Me.TextSearchHelpLabel.Location = New System.Drawing.Point(675, 140)
        Me.TextSearchHelpLabel.Name = "TextSearchHelpLabel"
        Me.TextSearchHelpLabel.Size = New System.Drawing.Size(29, 13)
        Me.TextSearchHelpLabel.TabIndex = 2
        Me.TextSearchHelpLabel.TabStop = True
        Me.TextSearchHelpLabel.Text = "Help"
        '
        'AdvancedTagList
        '
        Me.AdvancedTagList.BackColor = System.Drawing.SystemColors.Window
        Me.AdvancedTagList.BorderStyle = System.Windows.Forms.BorderStyle.None
        Me.AdvancedTagList.Font = New System.Drawing.Font("Arial", 8.25!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.AdvancedTagList.FormattingEnabled = True
        Me.AdvancedTagList.ItemHeight = 14
        Me.AdvancedTagList.Location = New System.Drawing.Point(408, 36)
        Me.AdvancedTagList.Name = "AdvancedTagList"
        Me.AdvancedTagList.Size = New System.Drawing.Size(326, 392)
        Me.AdvancedTagList.TabIndex = 6
        '
        'ToolTip1
        '
        Me.ToolTip1.Active = False
        Me.ToolTip1.AutoPopDelay = 5000
        Me.ToolTip1.InitialDelay = 500
        Me.ToolTip1.IsBalloon = True
        Me.ToolTip1.ReshowDelay = 500
        '
        'Label4
        '
        Me.Label4.AutoSize = True
        Me.Label4.Font = New System.Drawing.Font("Microsoft Sans Serif", 8.25!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Label4.Location = New System.Drawing.Point(534, 120)
        Me.Label4.Name = "Label4"
        Me.Label4.Size = New System.Drawing.Size(34, 13)
        Me.Label4.TabIndex = 8
        Me.Label4.Text = "Sort:"
        '
        'AdvancedTagCatCombo
        '
        Me.AdvancedTagCatCombo.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList
        Me.AdvancedTagCatCombo.FormattingEnabled = True
        Me.AdvancedTagCatCombo.Items.AddRange(New Object() {"All", "Components", "Conditions", "Misc", "Others", "Panels", "Substrate", "Systems"})
        Me.AdvancedTagCatCombo.Location = New System.Drawing.Point(414, 6)
        Me.AdvancedTagCatCombo.Name = "AdvancedTagCatCombo"
        Me.AdvancedTagCatCombo.Size = New System.Drawing.Size(314, 21)
        Me.AdvancedTagCatCombo.TabIndex = 9
        '
        'TabControl1
        '
        Me.TabControl1.Controls.Add(Me.TabPage2)
        Me.TabControl1.Controls.Add(Me.TabPage1)
        Me.TabControl1.Controls.Add(Me.TabPage3)
        Me.TabControl1.Controls.Add(Me.TabPage4)
        Me.TabControl1.Controls.Add(Me.TabPage5)
        Me.TabControl1.Controls.Add(Me.TabPage6)
        Me.TabControl1.Location = New System.Drawing.Point(1, 74)
        Me.TabControl1.Name = "TabControl1"
        Me.TabControl1.SelectedIndex = 0
        Me.TabControl1.Size = New System.Drawing.Size(748, 489)
        Me.TabControl1.TabIndex = 10
        '
        'TabPage1
        '
        Me.TabPage1.BackColor = System.Drawing.SystemColors.Control
        Me.TabPage1.Controls.Add(Me.TextSearchResults)
        Me.TabPage1.Controls.Add(Me.TextSearchBox)
        Me.TabPage1.Controls.Add(Me.TextSearchClear)
        Me.TabPage1.Controls.Add(Me.TextSearchButton)
        Me.TabPage1.Controls.Add(Me.Label1)
        Me.TabPage1.Controls.Add(Me.TextSearchHelpLabel)
        Me.TabPage1.Location = New System.Drawing.Point(4, 22)
        Me.TabPage1.Name = "TabPage1"
        Me.TabPage1.Padding = New System.Windows.Forms.Padding(3)
        Me.TabPage1.Size = New System.Drawing.Size(740, 463)
        Me.TabPage1.TabIndex = 0
        Me.TabPage1.Text = "Search"
        '
        'TextSearchResults
        '
        Me.TextSearchResults.BackColor = System.Drawing.SystemColors.Window
        Me.TextSearchResults.FormattingEnabled = True
        Me.TextSearchResults.Location = New System.Drawing.Point(37, 222)
        Me.TextSearchResults.Name = "TextSearchResults"
        Me.TextSearchResults.Size = New System.Drawing.Size(667, 95)
        Me.TextSearchResults.TabIndex = 101
        Me.TextSearchResults.Visible = False
        '
        'TabPage2
        '
        Me.TabPage2.BackColor = System.Drawing.SystemColors.Control
        Me.TabPage2.Controls.Add(Me.AdvancedClearButton)
        Me.TabPage2.Controls.Add(Me.AdvancedSearchButton)
        Me.TabPage2.Controls.Add(Me.Label10)
        Me.TabPage2.Controls.Add(Me.AdvancedTagAddButton)
        Me.TabPage2.Controls.Add(Me.AdvancedTagList)
        Me.TabPage2.Controls.Add(Me.AdvancedTagCatCombo)
        Me.TabPage2.Controls.Add(Me.Panel1)
        Me.TabPage2.Location = New System.Drawing.Point(4, 22)
        Me.TabPage2.Name = "TabPage2"
        Me.TabPage2.Padding = New System.Windows.Forms.Padding(3)
        Me.TabPage2.Size = New System.Drawing.Size(740, 463)
        Me.TabPage2.TabIndex = 1
        Me.TabPage2.Text = "Advanced Search"
        '
        'Label10
        '
        Me.Label10.AutoSize = True
        Me.Label10.Font = New System.Drawing.Font("Microsoft Sans Serif", 8.25!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Label10.Location = New System.Drawing.Point(411, 434)
        Me.Label10.Name = "Label10"
        Me.Label10.Size = New System.Drawing.Size(150, 13)
        Me.Label10.TabIndex = 111
        Me.Label10.Text = "Double Click To Add Tag"
        '
        'AdvancedTagAddButton
        '
        Me.AdvancedTagAddButton.Location = New System.Drawing.Point(659, 434)
        Me.AdvancedTagAddButton.Name = "AdvancedTagAddButton"
        Me.AdvancedTagAddButton.Size = New System.Drawing.Size(75, 23)
        Me.AdvancedTagAddButton.TabIndex = 10
        Me.AdvancedTagAddButton.Text = "Add"
        Me.AdvancedTagAddButton.UseVisualStyleBackColor = True
        '
        'TabPage3
        '
        Me.TabPage3.BackColor = System.Drawing.SystemColors.Control
        Me.TabPage3.Controls.Add(Me.Label14)
        Me.TabPage3.Controls.Add(Me.JobNumberOpenButton)
        Me.TabPage3.Controls.Add(Me.JobNumberList)
        Me.TabPage3.Location = New System.Drawing.Point(4, 22)
        Me.TabPage3.Name = "TabPage3"
        Me.TabPage3.Size = New System.Drawing.Size(740, 463)
        Me.TabPage3.TabIndex = 2
        Me.TabPage3.Text = "Job Number"
        '
        'JobNumberOpenButton
        '
        Me.JobNumberOpenButton.Location = New System.Drawing.Point(545, 387)
        Me.JobNumberOpenButton.Name = "JobNumberOpenButton"
        Me.JobNumberOpenButton.Size = New System.Drawing.Size(75, 23)
        Me.JobNumberOpenButton.TabIndex = 1
        Me.JobNumberOpenButton.Text = "Open"
        Me.JobNumberOpenButton.UseVisualStyleBackColor = True
        '
        'JobNumberList
        '
        Me.JobNumberList.FormattingEnabled = True
        Me.JobNumberList.Location = New System.Drawing.Point(120, 52)
        Me.JobNumberList.Name = "JobNumberList"
        Me.JobNumberList.Size = New System.Drawing.Size(500, 329)
        Me.JobNumberList.TabIndex = 0
        '
        'TabPage4
        '
        Me.TabPage4.BackColor = System.Drawing.SystemColors.Control
        Me.TabPage4.Controls.Add(Me.Label13)
        Me.TabPage4.Controls.Add(Me.JobNameOpenButton)
        Me.TabPage4.Controls.Add(Me.JobNameList)
        Me.TabPage4.Location = New System.Drawing.Point(4, 22)
        Me.TabPage4.Name = "TabPage4"
        Me.TabPage4.Size = New System.Drawing.Size(740, 463)
        Me.TabPage4.TabIndex = 3
        Me.TabPage4.Text = "Job Name"
        '
        'JobNameOpenButton
        '
        Me.JobNameOpenButton.Location = New System.Drawing.Point(545, 387)
        Me.JobNameOpenButton.Name = "JobNameOpenButton"
        Me.JobNameOpenButton.Size = New System.Drawing.Size(75, 23)
        Me.JobNameOpenButton.TabIndex = 3
        Me.JobNameOpenButton.Text = "Open"
        Me.JobNameOpenButton.UseVisualStyleBackColor = True
        '
        'JobNameList
        '
        Me.JobNameList.FormattingEnabled = True
        Me.JobNameList.Location = New System.Drawing.Point(120, 52)
        Me.JobNameList.Name = "JobNameList"
        Me.JobNameList.Size = New System.Drawing.Size(500, 329)
        Me.JobNameList.TabIndex = 2
        '
        'TabPage5
        '
        Me.TabPage5.BackColor = System.Drawing.SystemColors.Control
        Me.TabPage5.Controls.Add(Me.Label11)
        Me.TabPage5.Controls.Add(Me.Label7)
        Me.TabPage5.Controls.Add(Me.Label3)
        Me.TabPage5.Controls.Add(Me.NorthshoreStandardSystemOpenButton)
        Me.TabPage5.Controls.Add(Me.NorthshoreStandardDetailOpenButton)
        Me.TabPage5.Controls.Add(Me.NorthshoreStandardDetailList)
        Me.TabPage5.Controls.Add(Me.NorthshoreStandardSystemList)
        Me.TabPage5.Location = New System.Drawing.Point(4, 22)
        Me.TabPage5.Name = "TabPage5"
        Me.TabPage5.Size = New System.Drawing.Size(740, 463)
        Me.TabPage5.TabIndex = 4
        Me.TabPage5.Text = "Northshore Standards"
        '
        'Label7
        '
        Me.Label7.AutoSize = True
        Me.Label7.Font = New System.Drawing.Font("Microsoft Sans Serif", 8.25!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Label7.Location = New System.Drawing.Point(372, 51)
        Me.Label7.Name = "Label7"
        Me.Label7.Size = New System.Drawing.Size(40, 13)
        Me.Label7.TabIndex = 108
        Me.Label7.Text = "Detail"
        '
        'Label3
        '
        Me.Label3.AutoSize = True
        Me.Label3.Font = New System.Drawing.Font("Microsoft Sans Serif", 8.25!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Label3.Location = New System.Drawing.Point(70, 51)
        Me.Label3.Name = "Label3"
        Me.Label3.Size = New System.Drawing.Size(47, 13)
        Me.Label3.TabIndex = 107
        Me.Label3.Text = "System"
        '
        'NorthshoreStandardSystemOpenButton
        '
        Me.NorthshoreStandardSystemOpenButton.Enabled = False
        Me.NorthshoreStandardSystemOpenButton.Location = New System.Drawing.Point(279, 389)
        Me.NorthshoreStandardSystemOpenButton.Name = "NorthshoreStandardSystemOpenButton"
        Me.NorthshoreStandardSystemOpenButton.Size = New System.Drawing.Size(90, 23)
        Me.NorthshoreStandardSystemOpenButton.TabIndex = 3
        Me.NorthshoreStandardSystemOpenButton.Text = "Open System"
        Me.NorthshoreStandardSystemOpenButton.UseVisualStyleBackColor = True
        '
        'NorthshoreStandardDetailOpenButton
        '
        Me.NorthshoreStandardDetailOpenButton.Enabled = False
        Me.NorthshoreStandardDetailOpenButton.Location = New System.Drawing.Point(581, 389)
        Me.NorthshoreStandardDetailOpenButton.Name = "NorthshoreStandardDetailOpenButton"
        Me.NorthshoreStandardDetailOpenButton.Size = New System.Drawing.Size(90, 23)
        Me.NorthshoreStandardDetailOpenButton.TabIndex = 2
        Me.NorthshoreStandardDetailOpenButton.Text = "Open Detail"
        Me.NorthshoreStandardDetailOpenButton.UseVisualStyleBackColor = True
        '
        'NorthshoreStandardDetailList
        '
        Me.NorthshoreStandardDetailList.Enabled = False
        Me.NorthshoreStandardDetailList.FormattingEnabled = True
        Me.NorthshoreStandardDetailList.Location = New System.Drawing.Point(375, 67)
        Me.NorthshoreStandardDetailList.Name = "NorthshoreStandardDetailList"
        Me.NorthshoreStandardDetailList.Size = New System.Drawing.Size(296, 316)
        Me.NorthshoreStandardDetailList.TabIndex = 1
        '
        'NorthshoreStandardSystemList
        '
        Me.NorthshoreStandardSystemList.Enabled = False
        Me.NorthshoreStandardSystemList.FormattingEnabled = True
        Me.NorthshoreStandardSystemList.Location = New System.Drawing.Point(73, 67)
        Me.NorthshoreStandardSystemList.Name = "NorthshoreStandardSystemList"
        Me.NorthshoreStandardSystemList.Size = New System.Drawing.Size(296, 316)
        Me.NorthshoreStandardSystemList.TabIndex = 0
        '
        'TabPage6
        '
        Me.TabPage6.BackColor = System.Drawing.SystemColors.Control
        Me.TabPage6.Controls.Add(Me.Label12)
        Me.TabPage6.Controls.Add(Me.Label8)
        Me.TabPage6.Controls.Add(Me.Label9)
        Me.TabPage6.Controls.Add(Me.NorthcladStandardSystemOpenButton)
        Me.TabPage6.Controls.Add(Me.NorthcladStandardDetailOpenList)
        Me.TabPage6.Controls.Add(Me.NorthcladStandardDetailList)
        Me.TabPage6.Controls.Add(Me.NorthcladStandardSystemList)
        Me.TabPage6.Location = New System.Drawing.Point(4, 22)
        Me.TabPage6.Name = "TabPage6"
        Me.TabPage6.Size = New System.Drawing.Size(740, 463)
        Me.TabPage6.TabIndex = 5
        Me.TabPage6.Text = "Northclad Standards"
        '
        'Label8
        '
        Me.Label8.AutoSize = True
        Me.Label8.Font = New System.Drawing.Font("Microsoft Sans Serif", 8.25!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Label8.Location = New System.Drawing.Point(372, 51)
        Me.Label8.Name = "Label8"
        Me.Label8.Size = New System.Drawing.Size(40, 13)
        Me.Label8.TabIndex = 114
        Me.Label8.Text = "Detail"
        '
        'Label9
        '
        Me.Label9.AutoSize = True
        Me.Label9.Font = New System.Drawing.Font("Microsoft Sans Serif", 8.25!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Label9.Location = New System.Drawing.Point(70, 51)
        Me.Label9.Name = "Label9"
        Me.Label9.Size = New System.Drawing.Size(47, 13)
        Me.Label9.TabIndex = 113
        Me.Label9.Text = "System"
        '
        'NorthcladStandardSystemOpenButton
        '
        Me.NorthcladStandardSystemOpenButton.Enabled = False
        Me.NorthcladStandardSystemOpenButton.Location = New System.Drawing.Point(279, 389)
        Me.NorthcladStandardSystemOpenButton.Name = "NorthcladStandardSystemOpenButton"
        Me.NorthcladStandardSystemOpenButton.Size = New System.Drawing.Size(90, 23)
        Me.NorthcladStandardSystemOpenButton.TabIndex = 112
        Me.NorthcladStandardSystemOpenButton.Text = "Open System"
        Me.NorthcladStandardSystemOpenButton.UseVisualStyleBackColor = True
        '
        'NorthcladStandardDetailOpenList
        '
        Me.NorthcladStandardDetailOpenList.Enabled = False
        Me.NorthcladStandardDetailOpenList.Location = New System.Drawing.Point(581, 389)
        Me.NorthcladStandardDetailOpenList.Name = "NorthcladStandardDetailOpenList"
        Me.NorthcladStandardDetailOpenList.Size = New System.Drawing.Size(90, 23)
        Me.NorthcladStandardDetailOpenList.TabIndex = 111
        Me.NorthcladStandardDetailOpenList.Text = "Open Detail"
        Me.NorthcladStandardDetailOpenList.UseVisualStyleBackColor = True
        '
        'NorthcladStandardDetailList
        '
        Me.NorthcladStandardDetailList.Enabled = False
        Me.NorthcladStandardDetailList.FormattingEnabled = True
        Me.NorthcladStandardDetailList.Location = New System.Drawing.Point(375, 67)
        Me.NorthcladStandardDetailList.Name = "NorthcladStandardDetailList"
        Me.NorthcladStandardDetailList.Size = New System.Drawing.Size(296, 316)
        Me.NorthcladStandardDetailList.TabIndex = 110
        '
        'NorthcladStandardSystemList
        '
        Me.NorthcladStandardSystemList.Enabled = False
        Me.NorthcladStandardSystemList.FormattingEnabled = True
        Me.NorthcladStandardSystemList.Location = New System.Drawing.Point(73, 67)
        Me.NorthcladStandardSystemList.Name = "NorthcladStandardSystemList"
        Me.NorthcladStandardSystemList.Size = New System.Drawing.Size(296, 316)
        Me.NorthcladStandardSystemList.TabIndex = 109
        '
        'AdvancedClearButton
        '
        Me.AdvancedClearButton.Font = New System.Drawing.Font("Microsoft Sans Serif", 10.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.AdvancedClearButton.Location = New System.Drawing.Point(53, 429)
        Me.AdvancedClearButton.Name = "AdvancedClearButton"
        Me.AdvancedClearButton.Size = New System.Drawing.Size(141, 28)
        Me.AdvancedClearButton.TabIndex = 113
        Me.AdvancedClearButton.Text = "Clear"
        Me.AdvancedClearButton.UseVisualStyleBackColor = True
        '
        'AdvancedSearchButton
        '
        Me.AdvancedSearchButton.Font = New System.Drawing.Font("Microsoft Sans Serif", 10.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.AdvancedSearchButton.Location = New System.Drawing.Point(200, 429)
        Me.AdvancedSearchButton.Name = "AdvancedSearchButton"
        Me.AdvancedSearchButton.Size = New System.Drawing.Size(141, 28)
        Me.AdvancedSearchButton.TabIndex = 112
        Me.AdvancedSearchButton.Text = "Search"
        Me.AdvancedSearchButton.UseVisualStyleBackColor = True
        '
        'Label11
        '
        Me.Label11.AutoSize = True
        Me.Label11.Font = New System.Drawing.Font("Microsoft Sans Serif", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Label11.ForeColor = System.Drawing.Color.Maroon
        Me.Label11.Location = New System.Drawing.Point(69, 24)
        Me.Label11.Name = "Label11"
        Me.Label11.Size = New System.Drawing.Size(121, 20)
        Me.Label11.TabIndex = 109
        Me.Label11.Text = "Coming Soon!"
        '
        'Label12
        '
        Me.Label12.AutoSize = True
        Me.Label12.Font = New System.Drawing.Font("Microsoft Sans Serif", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Label12.ForeColor = System.Drawing.Color.Maroon
        Me.Label12.Location = New System.Drawing.Point(69, 24)
        Me.Label12.Name = "Label12"
        Me.Label12.Size = New System.Drawing.Size(121, 20)
        Me.Label12.TabIndex = 115
        Me.Label12.Text = "Coming Soon!"
        '
        'Label13
        '
        Me.Label13.AutoSize = True
        Me.Label13.Location = New System.Drawing.Point(117, 36)
        Me.Label13.Name = "Label13"
        Me.Label13.Size = New System.Drawing.Size(168, 13)
        Me.Label13.TabIndex = 4
        Me.Label13.Text = "Select Job Name To Open Details"
        '
        'Label14
        '
        Me.Label14.AutoSize = True
        Me.Label14.Location = New System.Drawing.Point(117, 36)
        Me.Label14.Name = "Label14"
        Me.Label14.Size = New System.Drawing.Size(177, 13)
        Me.Label14.TabIndex = 2
        Me.Label14.Text = "Select Job Number To Open Details"
        '
        'Label15
        '
        Me.Label15.AutoSize = True
        Me.Label15.Font = New System.Drawing.Font("Microsoft Sans Serif", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Label15.ForeColor = System.Drawing.Color.Maroon
        Me.Label15.Location = New System.Drawing.Point(5, 342)
        Me.Label15.Name = "Label15"
        Me.Label15.Size = New System.Drawing.Size(202, 20)
        Me.Label15.TabIndex = 111
        Me.Label15.Text = "Exclusion Coming Soon!"
        '
        'Form1
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.BackColor = System.Drawing.SystemColors.Control
        Me.ClientSize = New System.Drawing.Size(750, 612)
        Me.Controls.Add(Me.TabControl1)
        Me.Controls.Add(Me.Label4)
        Me.Controls.Add(Me.Label2)
        Me.Controls.Add(Me.GlobalExitButton)
        Me.Controls.Add(Me.GlobalDatabaseSizeLabel)
        Me.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle
        Me.Icon = CType(resources.GetObject("$this.Icon"), System.Drawing.Icon)
        Me.Name = "Form1"
        Me.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen
        Me.Text = "Northshore Library Search - V-NSM-DC-01"
        Me.Panel1.ResumeLayout(False)
        Me.Panel1.PerformLayout()
        Me.TabControl1.ResumeLayout(False)
        Me.TabPage1.ResumeLayout(False)
        Me.TabPage1.PerformLayout()
        Me.TabPage2.ResumeLayout(False)
        Me.TabPage2.PerformLayout()
        Me.TabPage3.ResumeLayout(False)
        Me.TabPage3.PerformLayout()
        Me.TabPage4.ResumeLayout(False)
        Me.TabPage4.PerformLayout()
        Me.TabPage5.ResumeLayout(False)
        Me.TabPage5.PerformLayout()
        Me.TabPage6.ResumeLayout(False)
        Me.TabPage6.PerformLayout()
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub
    Friend WithEvents TextSearchBox As System.Windows.Forms.TextBox
    Friend WithEvents Label1 As System.Windows.Forms.Label
    Friend WithEvents Label2 As System.Windows.Forms.Label
    Friend WithEvents TextSearchButton As System.Windows.Forms.Button
    Friend WithEvents GlobalExitButton As System.Windows.Forms.Button
    Friend WithEvents Panel1 As System.Windows.Forms.Panel
    Friend WithEvents TextSearchHelpLabel As System.Windows.Forms.LinkLabel
    Friend WithEvents AdvancedTagList As System.Windows.Forms.ListBox
    Friend WithEvents ToolTip1 As System.Windows.Forms.ToolTip
    Friend WithEvents Label4 As System.Windows.Forms.Label
    Friend WithEvents AdvancedTagCatCombo As System.Windows.Forms.ComboBox
    Friend WithEvents GlobalDatabaseSizeLabel As System.Windows.Forms.Label
    Friend WithEvents TextSearchClear As System.Windows.Forms.Button
    Friend WithEvents Label6 As System.Windows.Forms.Label
    Friend WithEvents Label5 As System.Windows.Forms.Label
    Friend WithEvents TabControl1 As System.Windows.Forms.TabControl
    Friend WithEvents TabPage1 As System.Windows.Forms.TabPage
    Friend WithEvents TabPage2 As System.Windows.Forms.TabPage
    Friend WithEvents TextSearchResults As System.Windows.Forms.ListBox
    Friend WithEvents TabPage3 As System.Windows.Forms.TabPage
    Friend WithEvents TabPage4 As System.Windows.Forms.TabPage
    Friend WithEvents TabPage5 As System.Windows.Forms.TabPage
    Friend WithEvents TabPage6 As System.Windows.Forms.TabPage
    Friend WithEvents AdvancedExcludeButton As System.Windows.Forms.Button
    Friend WithEvents AdvancedIncludeRemoveButton As System.Windows.Forms.Button
    Friend WithEvents AdvancedExcludeList As System.Windows.Forms.ListBox
    Friend WithEvents AdvancedIncludeList As System.Windows.Forms.ListBox
    Friend WithEvents AdvancedTagAddButton As System.Windows.Forms.Button
    Friend WithEvents JobNumberOpenButton As System.Windows.Forms.Button
    Friend WithEvents JobNumberList As System.Windows.Forms.ListBox
    Friend WithEvents JobNameOpenButton As System.Windows.Forms.Button
    Friend WithEvents JobNameList As System.Windows.Forms.ListBox
    Friend WithEvents Label7 As System.Windows.Forms.Label
    Friend WithEvents Label3 As System.Windows.Forms.Label
    Friend WithEvents NorthshoreStandardSystemOpenButton As System.Windows.Forms.Button
    Friend WithEvents NorthshoreStandardDetailOpenButton As System.Windows.Forms.Button
    Friend WithEvents NorthshoreStandardDetailList As System.Windows.Forms.ListBox
    Friend WithEvents NorthshoreStandardSystemList As System.Windows.Forms.ListBox
    Friend WithEvents Label8 As System.Windows.Forms.Label
    Friend WithEvents Label9 As System.Windows.Forms.Label
    Friend WithEvents NorthcladStandardSystemOpenButton As System.Windows.Forms.Button
    Friend WithEvents NorthcladStandardDetailOpenList As System.Windows.Forms.Button
    Friend WithEvents NorthcladStandardDetailList As System.Windows.Forms.ListBox
    Friend WithEvents NorthcladStandardSystemList As System.Windows.Forms.ListBox
    Friend WithEvents Label10 As System.Windows.Forms.Label
    Friend WithEvents AdvancedClearButton As System.Windows.Forms.Button
    Friend WithEvents AdvancedSearchButton As System.Windows.Forms.Button
    Friend WithEvents Label15 As System.Windows.Forms.Label
    Friend WithEvents Label14 As System.Windows.Forms.Label
    Friend WithEvents Label13 As System.Windows.Forms.Label
    Friend WithEvents Label11 As System.Windows.Forms.Label
    Friend WithEvents Label12 As System.Windows.Forms.Label

End Class
