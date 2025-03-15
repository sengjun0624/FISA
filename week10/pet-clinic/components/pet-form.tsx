"use client"

import type React from "react"

import { useState } from "react"
import { Input } from "@/components/ui/input"
import { Button } from "@/components/ui/button"
import { Label } from "@/components/ui/label"
import { Card, CardContent } from "@/components/ui/card"
import { Select, SelectContent, SelectItem, SelectTrigger, SelectValue } from "@/components/ui/select"
const API_BASE_URL = process.env.NEXT_PUBLIC_API_BASE_URL || "http://localhost:8080";

interface PetFormProps {
  ownerId: number
  onSuccess: () => void
}

interface PetFormData {
  name: string
  birthDate: string
  type: string
}

export default function PetForm({ ownerId, onSuccess }: PetFormProps) {
  const [formData, setFormData] = useState<PetFormData>({
    name: "",
    birthDate: new Date().toISOString().split("T")[0],
    type: "DOG",
  })
  const [isLoading, setIsLoading] = useState(false)
  const [error, setError] = useState<string | null>(null)

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value } = e.target
    setFormData((prev) => ({ ...prev, [name]: value }))
  }

  const handleSelectChange = (name: string, value: string) => {
    setFormData((prev) => ({ ...prev, [name]: value }))
  }

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault()
    setIsLoading(true)
    setError(null)

    try {
      const response = await fetch(`http://localhost:8080/owners/${ownerId}/pets/new`, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(formData),
      })

      if (!response.ok) {
        throw new Error("저장 중 오류가 발생했습니다")
      }

      onSuccess()
    } catch (err) {
      setError(err instanceof Error ? err.message : "저장 중 오류가 발생했습니다")
    } finally {
      setIsLoading(false)
    }
  }

  return (
    <Card>
      <CardContent className="pt-6">
        <form onSubmit={handleSubmit} className="space-y-4">
          <div className="space-y-2">
            <Label htmlFor="name" className="text-[#333D4B]">
              이름
            </Label>
            <Input
              id="name"
              name="name"
              value={formData.name}
              onChange={handleChange}
              required
              className="h-12 rounded-xl border-gray-200 focus:border-[#3182F6] focus:ring-[#3182F6]"
            />
          </div>

          <div className="space-y-2">
            <Label htmlFor="birthDate" className="text-[#333D4B]">
              생년월일
            </Label>
            <Input
              id="birthDate"
              name="birthDate"
              type="date"
              value={formData.birthDate}
              onChange={handleChange}
              required
              className="h-12 rounded-xl border-gray-200 focus:border-[#3182F6] focus:ring-[#3182F6]"
            />
          </div>

          <div className="space-y-2">
            <Label htmlFor="type" className="text-[#333D4B]">
              종류
            </Label>
            <Select value={formData.type} onValueChange={(value) => handleSelectChange("type", value)}>
              <SelectTrigger className="h-12 rounded-xl border-gray-200 focus:border-[#3182F6] focus:ring-[#3182F6]">
                <SelectValue placeholder="종류 선택" />
              </SelectTrigger>
              <SelectContent>
                <SelectItem value="DOG">강아지</SelectItem>
                <SelectItem value="CAT">고양이</SelectItem>
                <SelectItem value="BIRD">새</SelectItem>
                <SelectItem value="HAMSTER">햄스터</SelectItem>
                <SelectItem value="RABBIT">토끼</SelectItem>
              </SelectContent>
            </Select>
          </div>

          {error && <div className="p-3 text-center text-red-500 bg-red-50 rounded-xl">{error}</div>}

          <Button
            type="submit"
            disabled={isLoading}
            className="w-full h-12 rounded-xl bg-[#3182F6] hover:bg-[#1b64da] text-white font-medium"
          >
            {isLoading ? "등록 중..." : "반려동물 등록하기"}
          </Button>
        </form>
      </CardContent>
    </Card>
  )
}

